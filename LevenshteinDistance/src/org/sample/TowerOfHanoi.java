package org.sample;

public class TowerOfHanoi {
	
	private static int moveCount = 1;

	public static void towerofHanoi(int n, char sourceTower, char auxiliaryTower, char destinationTower){
		if(n >= 1){
			// step 1: move top n-1 disks from source to auxiliary tower using destination tower as auxiliary
			towerofHanoi(n-1, sourceTower, destinationTower, auxiliaryTower);
			// step 2: move last disk (nth) from source to destination tower			
			System.out.println("Move No. "+(moveCount++)+": Moving Disk No. "+n+" from Tower "+sourceTower+" to "+destinationTower);
			// step 3: move all the n-1 disks from auxiliary to destination tower using source tower as auxiliary
			towerofHanoi(n-1, auxiliaryTower, sourceTower, destinationTower);
			
		}
	}
	
	public static void main(String[] args) {
		towerofHanoi(4, 'A', 'B', 'C');
	}
}
