;
	private List<Integer>[] gearList;

	public GearController() {
		gear = new LinkedList<>();
		gearList = (List<Integer>[]) new List[numOfGears + 1];
	}

	public void init() throws IOException {

		for (int i = 0; i < numOfGears; i++) {
			String input = br.readLine();
			gearList[i] = new ArrayList<>();
			for (int j = 0; j < input.length(); j++) {
				gearList[i].add(input.charAt(j) - '0');
			}
		}

	}

	public void executeCmd() throws IOException {
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			String[] inputs = br.readLine().split(" ");
			int gearNo = Integer.parseInt(inputs[0]);
			int dir = Integer.parseInt(inputs[1]);
			rotateGear(gearNo - 1, dir);
		}
	}

	public void rotateGear(int gearNo, int dir) {
		boolean isClockWise = dir == CLOCK_WISE ? true : false;
		int pivotLeft = gearList[gearNo].get(6);
		int pivotRight = gearList[gearNo].get(2);
		
		if (isClockWise) {
			rotateClockWise(gearNo);
		} else {
			rotateCounterClockWise(gearNo);
			isClockWise = false;
		}
		
		
		boolean targetDir = isClockWise;
		int i = gearNo - 1;
		while (i >= 0) {
			if (gearList[i].get(2) == pivotLeft) {
				break;
			}
			pivotLeft = gearList[i].get(6);

			if (isClockWise) {
				rotateCounterClockWise(i);
				isClockWise = false;
			} else {
				rotateClockWise(i);
				isClockWise = true;
			}
			i -= 1;
		}
		i = gearNo + 1;
		isClockWise = targetDir;
		while (i < numOfGears) {
			if (gearList[i].get(6) == pivotRight) {
				break;
			}
			pivotRight = gearList[i].get(2);
			if (isClockWise) {
				rotateCounterClockWise(i);
				isClockWise = false;
			} else {
				rotateClockWise(i);
				isClockWise = true;
			}
			i += 1;
		}

	}

	public void printGearScore() {

		int[][] scoreTable = { { 0, 1 }, { 0, 2 }, { 0, 4 }, { 0, 8 } };
		int score = 0;
		for (int i = 0; i < numOfGears; i++) {
			score += scoreTable[i][gearList[i].get(0)];
		}
		System.out.println(score);
	}

	public void rotateClockWise(int gearNo) {
		gearList[gearNo].add(0, gearList[gearNo].remove(7));
	}

	public void rotateCounterClockWise(int gearNo) {
		int tmp = gearList[gearNo].remove(0);
		gearList[gearNo].add(tmp);
	}

}
