package me.y2o2u2n.p1366;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-05-20
 */
class RankTeamsByVotesTest {

	@Test
	void rankTeams() {
		RankTeamsByVotes sut = new RankTeamsByVotes();

		assertEquals("ACB", sut.rankTeams(new String[] {"ABC", "ACB", "ABC", "ACB", "ACB"}));
		assertEquals("XWYZ", sut.rankTeams(new String[] {"WXYZ", "XYZW"}));
	}
}