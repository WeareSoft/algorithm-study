package etc;

import java.util.*;

public class NV01 {

	public static void main(String[] args) {
		String s = "/root";
//		System.out.println(Arrays.toString(new NV01().solution(new String[]{"/", "/root", "/root/abcd", "/root/abcd/etc", "/root/abcd/hello", "/root/tmp", "/root/tmp/hello", "/root/tmp/hello/tmp"}, new String[]{})));
//		System.out.println(Arrays.toString(new NV01().solution(new String[]{"/", "/hello", "/hello/tmp", "/root", "/root/abcd", "/root/abcd/etc", "/root/abcd/hello"}, new String[]{})));
		System.out.println(Arrays.toString(new NV01().solution(new String[]{"/", "/hello", "/hello/tmp", "/root", "/root/abcd", "/root/abcd/etc", "/root/abcd/hello"}, new String[]{"cp /hello /root/tmp"})));


	}

	public String[] solution(String[] directory, String[] command) {
		Directory root = new Directory(null, directory[0]);
		for (int i = 1; i < directory.length; i++) {
			mkdir(root, directory[i]);
		}

		mkdir(root, "/root/tmp");
		cp(root, "/hello", "/root/tmp");
		rm(root, "/hello");

		List<String> result = root.tree(new ArrayList<>());
		return result.toArray(new String[0]);
	}

	public void mkdir(Directory root, String path) {
		String[] pathElements = path.split("/");

		String[] onlyPath = Arrays.copyOfRange(pathElements, 1, pathElements.length - 1); // 경로만 추출
		Directory dir = (Directory) root.open(onlyPath); // 해당 경로의 디렉토리

		String name = pathElements[pathElements.length - 1]; // 생성 디렉토리 이름 추출
		dir.add(new Directory(dir, name)); // 디렉토리 생성 및 추가
	}

	public void cp(Directory root, String sourcePath, String destPath) {
		String[] srcPathElements = sourcePath.split("/");
		String[] onlyPath = Arrays.copyOfRange(srcPathElements, 1, srcPathElements.length);
		Directory sourceDir = (Directory) root.open(onlyPath);
		Directory copiedDir = (Directory) sourceDir.remove();

		String[] destPathElements = destPath.split("/");
		onlyPath = Arrays.copyOfRange(destPathElements, 1, destPathElements.length);
		Directory destDir = (Directory) root.open(onlyPath);
		destDir.add(copiedDir);
		System.out.println(copiedDir);
	}

	private void rm(Directory root, String path) {
		String[] pathElements = path.split("/");
		String[] onlyPath = Arrays.copyOfRange(pathElements, 1, pathElements.length);
		Directory sourceDir = (Directory) root.open(onlyPath);
		System.out.println(sourceDir);
		sourceDir.remove();
	}


	class Directory extends File {
		public Directory(File parent, String name) {
			super(parent, name);
		}

		private Map<String, File> list;

		public void add(File file) {
			if (Objects.isNull(list)) {
				list = new HashMap<>();
			}
			list.put(file.name, file);
		}

		public File remove() {
			return remove(this);
		}

		public File remove(File file) {
			return ((Directory) this.parent).list.remove(file.name);
		}

		public File open(String[] path) {
			return open(path, 0);
		}

		private File open(String[] path, int depth) {
			if (depth == path.length) {
				return this;
			}
			String name = path[depth];
			Directory nextDir = (Directory) list.get(name);
			return nextDir.open(path, depth + 1);
		}

		public List<String> tree(List<String> result) {
			result.add(this.toString());
			if (Objects.isNull(list) || list.isEmpty()) {
				return result;
			}

			for (String name : list.keySet()) {
				((Directory) list.get(name)).tree(result);
			}

			return result;
		}


	}

	class File {
		protected String name;
		protected File parent;

		public File(File parent, String name) {
			this.parent = parent;
			this.name = name;
		}

		public File getParent() {
			return parent;
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
