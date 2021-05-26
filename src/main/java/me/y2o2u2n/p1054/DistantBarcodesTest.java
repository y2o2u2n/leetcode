package me.y2o2u2n.p1054;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-05-26
 */
class DistantBarcodesTest {

	@Test
	void rearrangeBarcodes() {
		DistantBarcodes sut = new DistantBarcodes();

		assertFalse(hasEqualAdjacentBarcode(sut.rearrangeBarcodes(new int[] {1, 1, 1, 2, 2, 2})));
		assertFalse(hasEqualAdjacentBarcode(sut.rearrangeBarcodes(new int[] {1, 1, 1, 1, 2, 2, 3, 3})));
		assertFalse(hasEqualAdjacentBarcode(sut.rearrangeBarcodes(new int[] {1, 3, 1, 1, 3, 2, 2, 1})));
	}

	private boolean hasEqualAdjacentBarcode(int[] barcodes) {
		int prev = barcodes[0];

		for (int i = 1; i < barcodes.length; i++) {
			int current = barcodes[i];
			if (current == prev) {
				return true;
			}

			prev = current;
		}

		return false;
	}
}