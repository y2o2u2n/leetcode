package me.y2o2u2n.woowa.task2;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/07/31
 */
class Task2Test {

	@Test
	void case1() {
		new Task2().solution(
			"my.song.mp3 11b\n"
				+ "greatSong.flac 1000b\n"
				+ "not3.txt 5b\n"
				+ "video.mp4 200b\n"
				+ "game.exe 100b\n"
				+ "/^&'@{}[],$=!-#()%.+~_.mkv 10000b");
	}

}