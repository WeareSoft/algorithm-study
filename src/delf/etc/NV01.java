package etc;

import java.util.*;

public class NV01 {

	public static void main(String[] args) {
		String s = "/root/pm/vv";
		System.out.println(Arrays.toString(s.split("/")));
	}

	public String[] solution(String[] directory, String[] command) {
		Directory root = new Directory(null, "/");
		return new String[]{};
	}

	public void mkdir(Directory root, String path) {
		File dir = root.open(path);
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
			list.put(name, file);
		}

		public boolean remove(File file) {
			return !list.isEmpty() && list.containsKey(name);
		}

		private File open(String[] path, int depth) {
			return null;
		}

		public File open(String path) {
			return list.get(path);
		}
	}

	class File {
		protected String name;
		private File parent;

		public File(File parent, String name) {
			this.parent = parent;
			this.name = name;
		}

		@Override
		public String toString() {
			if (parent == null) {
				return name;
			}
			return parent.name + "/" + name;
		}
	}
}
