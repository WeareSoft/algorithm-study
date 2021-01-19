package dami.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Array를 List로 변환할 때 List list = Arrays.asList(array); 하면 불변 List(unmodifiable)가 되어 수정 불가
// => 수정 시, UnsupportedOperationException 발생
// 따라서 아래 방법 중 하나로 생성
// 1. List 생성 후 addAll
//	=> reference가 그대로 전달
// 2. new ArrayList<>(Arrays.asList(array));
//  => copy이기 때문에 reference는 없어지지만 불필요하게 두 개 생성

public class Line6 {
	public String[] solution(String[] directory, String[] commands) {
		Directories directories = Directories.of(directory);

		for (String command : commands) {
			directories.executeCommand(command);
		}

		return directories.asArray();
	}
}

class Directories {
	private final List<String> directories;

	public Directories(List<String> directories) {
		this.directories = new ArrayList<>();
		this.directories.addAll(directories);
	}

	public static Directories of(String[] directories) {
		return new Directories(Arrays.asList(directories));
	}

	public String[] asArray() {
		return directories.toArray(new String[0]);
	}

	public void executeCommand(String command) {
		String[] splitCommand = command.split(" ");

		if (command.contains("mkdir")) {
			mkdir(splitCommand[1]);
			return;
		}

		if (command.contains("cp")) {
			cp(splitCommand[1], splitCommand[2].equals("/") ? "" : splitCommand[2]);
			return;
		}

		if (command.contains("rm")) {
			rm(splitCommand[1]);
		}
	}

	private void mkdir(String newDirectory) {
		directories.add(newDirectory);
	}

	private void cp(String source, String destination) {
		int lastIndex = source.lastIndexOf("/");
		directories.addAll(
				directories.stream()
						.filter(dir -> dir.startsWith(source))
						.map(dir -> destination + dir.substring(lastIndex))
						.collect(Collectors.toList())
		);
	}

	private void rm(String rmDirectory) {
		directories.removeIf(dir -> dir.startsWith(rmDirectory));
	}
}
