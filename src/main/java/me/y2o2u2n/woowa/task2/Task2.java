package me.y2o2u2n.woowa.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by JunSeok Youn on 2021/07/31
 */
public class Task2 {

	public String solution(String S) {
		FileStatistic fileStatistic = new FileStatistic(S);
		String report = fileStatistic.report();
		System.out.println(report);
		return report;
	}

	public static class FileStatistic {
		private final Map<FileType, List<File>> filesByType;

		public FileStatistic(String S) {
			String[] lines = S.split("\n");
			if (lines.length > 500) {
				throw new IllegalArgumentException("500 라인을 넘을 수 없습니다.");
			}

			filesByType = new HashMap<>();
			for (String line : lines) {
				File file = new File(line);
				List<File> files = filesByType.getOrDefault(file.type, new ArrayList<>());
				files.add(file);
				filesByType.put(file.type, files);
			}
		}

		public String report() {
			List<FileType> types = new ArrayList<>();
			types.add(FileType.MUSIC);
			types.add(FileType.IMAGE);
			types.add(FileType.MOVIE);
			types.add(FileType.OTHER);

			List<String> lineList = new ArrayList<>();
			for (FileType type : types) {
				List<File> files = filesByType.getOrDefault(type, new ArrayList<>());
				Optional<Long> optional = files.stream()
					.map(file -> file.size)
					.map(size -> size.bytes)
					.reduce(Long::sum);
				long sum = optional.isPresent() ? optional.get() : 0;
				lineList.add(String.format("%s %db", type.name, sum));
			}

			return String.join("\n", lineList);
		}
	}

	public static class File {
		private final FileName name;
		private final FileExtension extension;
		private final FileType type;
		private final FileSize size;

		public File(String line) {
			String[] tokens = line.split(" ");
			String fullName = tokens[0];
			if (fullName.length() > 30) {
				throw new IllegalArgumentException("확장자를 포함한 파일명은 30자를 넘을 수 없습니다.");
			}

			int i = fullName.lastIndexOf(".");
			if (i < 0) {
				throw new IllegalArgumentException("파일 확장자가 없습니다.");
			}

			name = new FileName(fullName.substring(0, i));
			extension = new FileExtension(fullName.substring(i + 1));
			type = FileType.findBy(extension);
			size = new FileSize(tokens[1]);
		}
	}

	public static class FileName {
		private final String name;

		public FileName(String name) {
			if (name == null || name.isEmpty()) {
				throw new IllegalArgumentException("파일 이름이 비어있습니다.");
			}

			if (!name.matches("^[a-zA-Z0-9/^&'@{}\\[\\],$=!\\-#()%.+~_]+$")) {
				throw new IllegalArgumentException("파일 이름은 a-z, A-Z, 0-9 와 ^&'@{}[],$=!-#()%.+~_ 만 가능합니다.");
			}

			this.name = name;
		}
	}

	public static class FileExtension {
		private final String extension;

		public FileExtension(String extension) {
			if (extension == null || extension.isEmpty()) {
				throw new IllegalArgumentException("파일 확장자가 비어있습니다.");
			}

			if (!extension.matches("^[a-z0-9]+$")) {
				throw new IllegalArgumentException("파일 확장자는 a-z, 0-9 의 문자만 가능합니다.");
			}

			this.extension = extension;
		}
	}

	public enum FileType {
		MUSIC("music", Arrays.asList("mp3", "aac", "flac")),
		IMAGE("images", Arrays.asList("jpg", "bmp", "gif")),
		MOVIE("movies", Arrays.asList("mp4", "avi", "mkv")),
		OTHER("other", Collections.emptyList());

		private final String name;
		private final List<String> extensions;

		FileType(String name, List<String> extensions) {
			this.name = name;
			this.extensions = extensions;
		}

		public static FileType findBy(FileExtension extension) {
			List<FileType> types = Arrays.stream(values())
				.filter(type -> type != OTHER)
				.collect(Collectors.toList());

			for (FileType type : types) {
				for (String typeExtension : type.extensions) {
					if (typeExtension.equals(extension.extension)) {
						return type;
					}
				}
			}

			return OTHER;
		}
	}

	public static class FileSize {
		private final long bytes;

		public FileSize(String string) {
			String byteStr = string.replace("b", "");

			long bytes;
			try {
				bytes = Long.parseLong(byteStr);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("파일 크기 형식이 아닙니다.");
			}

			if (bytes < 0) {
				throw new IllegalArgumentException("파일의 크기가 0 보다 작을 수 없습니다.");
			}

			if (bytes > 1_000_000) {
				throw new IllegalArgumentException("파일의 크기가 1,000,000 를 초과합니다.");
			}

			this.bytes = bytes;
		}
	}
}
