package etc.ln;

import java.util.*;

public class Ln06 {

	public static void main(String[] args) throws CloneNotSupportedException {
		System.out.println(Arrays.toString(new Ln06().solution(
				new String[]{"/", "/hello", "/hello/tmp", "/root", "/root/abcd", "/root/abcd/etc", "/root/abcd/hello"},
				new String[]{"mkdir /root/tmp", "cp /hello /root/tmp", "rm /hello"}))
		);

		System.out.println(Arrays.toString(new Ln06().solution(
				new String[]{"/"},
				new String[]{"mkdir /a", "mkdir /a/b", "mkdir /a/b/c", "cp /a/b /", "rm /a/b/c"}))
		);

		System.out.println(Arrays.toString(new Ln06().solution(
				new String[]{"/"},
				new String[]{"mkdir /a", "mkdir /a/b", "mkdir /a/b/c", "cp /a/b /", "rm /a/b/c"}))
		);
	}

	public String[] solution(String[] directory, String[] command) throws CloneNotSupportedException {
		/* (인자로 받은) 초기 디렉토리 생성 */
		Directory root = new Directory(null, directory[0]); // 루트 생성
		for (int i = 1; i < directory.length; i++) {
			mkdir(root, directory[i]);
		}

		/* 명령 수행 */
		for (String cmd : command) {
			String[] arg = cmd.split(" ");
			switch (arg[0]) { // 명령어
				case "mkdir":
					mkdir(root, arg[1]);
					break;
				case "cp":
					cp(root, arg[1], arg[2]);
					break;
				case "rm":
					rm(root, arg[1]);
					break;
			}
		}

		/* 출력 */
		return root.tree(new ArrayList<>()).stream()
				.sorted(String::compareTo)
				.toArray(String[]::new);
	}

	public void mkdir(Directory root, String path) {
		String[] pathElements = path.split("/");

		String[] onlyPath = Arrays.copyOfRange(pathElements, 1, pathElements.length - 1); // 경로만 추출
		Directory dir = (Directory) root.open(onlyPath); // 해당 경로의 디렉토리

		String name = pathElements[pathElements.length - 1]; // 생성 디렉토리 이름 추출
		dir.add(new Directory(dir, name)); // 디렉토리 생성 및 추가
	}

	public void cp(Directory root, String sourcePath, String destPath) throws CloneNotSupportedException {
		String[] onlyPath = getPath(sourcePath);
		Directory sourceDir = (Directory) root.open(onlyPath); // src 디렉토리 가져오기

		onlyPath = getPath(destPath);
		Directory destDir = (Directory) root.open(onlyPath); // dest 디렉토리 가져오기

		Directory copied = (Directory) sourceDir.clone(); // 복사
		destDir.add(copied); // 추가
	}

	public void rm(Directory root, String path) {
		String[] onlyPath = getPath(path);
		Directory sourceDir = (Directory) root.open(onlyPath); // 삭제할 디렉토리 가져오기
		sourceDir.remove();
	}

	private String[] getPath(String path) { // 매핑
		String[] pathElements = path.split("/");
		if (pathElements.length == 0) {
			return new String[]{};
		}
		return Arrays.copyOfRange(pathElements, 1, pathElements.length);
	}


	class Directory extends File {
		public Directory(File parent, String name) {
			super(parent, name);
		}

		private Map<String, File> list; // 하위 디렉토리(파일)

		public void add(File file) { // 디렉토리(파일) 추가
			if (Objects.isNull(list)) {
				list = new HashMap<>();
			}
			file.parent = this;
			list.put(file.name, file);
		}

		public File remove() {
			return remove(this);
		}

		public File remove(File file) {
			return ((Directory) this.parent).list.remove(file.name); // 자신의 부모의 list에서 자신을 삭제
		}

		public File open(String[] path) {
			return open(path, 0); // depth: 들어간 깊이
		}

		private File open(String[] path, int depth) {
			if (depth == path.length) { // 목적지 도달
				return this;
			}
			// 다음 디렉토리 찾아서 열기 반복
			String name = path[depth];
			Directory nextDir = (Directory) list.get(name);
			return nextDir.open(path, depth + 1);
		}

		public List<String> tree(List<String> result) { // 배열의 형태로 출력하기 위해 List받음
			result.add(this.toString()); // dfs 하면서 추가 (toString() 오버라이드)
			if (Objects.isNull(list) || list.isEmpty()) {
				return result;
			}

			for (String name : list.keySet()) {
				((Directory) list.get(name)).tree(result);
			}
			return result;
		}

		@Override
		protected Object clone() { // 깊은 복사를 위한 오버라이딩
			Directory dir = new Directory(this.parent, this.name);
			dir.list = new HashMap<>();
			for (String s : list.keySet()) {
				dir.list.put(s, new Directory(dir, s));
			}
			return dir;
		}
	}

	class File {
		protected String name;
		protected File parent;

		public File(File parent, String name) {
			this.parent = parent;
			this.name = name;
		}

		@Override
		public String toString() {
			if (parent == null) {
				return name;
			}
			if (parent.parent == null) {
				return "/" + name;
			}
			return parent + "/" + name;
		}
	}
}
