import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	Parameter ratedS = new Parameter();
	Parameter ratedR = new Parameter();
	Parameter ratedO = new Parameter();
	Customer[] customers = null;
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		Test aiSolution = new Test();
		aiSolution.start();
	}

	public void start() throws Exception {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("\t\t\t" + "Loading...");
		Thread.sleep(1500);
		while (true) {
			try {
				startScreen();
				int chosenStartScreen = input.nextInt();
				if (chosenStartScreen == 5) {
					System.out.println();
					System.out.println("\t\t\t" + "Bye...");
					Thread.sleep(1500);
					System.exit(0);
					break;
				} else if (chosenStartScreen == 1) {
					setParameter();
				} else if (chosenStartScreen == 2) {
					inputCustomer();
				} else if (chosenStartScreen == 3) {
					viewCustomer();
				} else if (chosenStartScreen == 4) {
					editCustomer();
				} else {
					System.out.println("Choose from 1 ~ 5");
				}
			} catch (InputMismatchException e) {
				e.getMessage();
				System.out.println();
				System.out.println("Numbers Only!");
				input.next();
				continue;
			}
		}
	}

	public void startScreen() {
		System.out.println();
		System.out.println("=================================================================");
		System.out.println("==============     Program For Smartstore Owner    ==============");
		System.out.println();
		System.out.println("1. Set The Group Parameter");
		System.out.println("2. Input Customer's Information");
		System.out.println("3. View Customer's Information");
		System.out.println("4. Edit Customer's Information");
		System.out.println("5. Exit");
		System.out.println();
		System.out.println("=================================================================");
		System.out.println();
		System.out.print("Choose One : ");
		System.out.println();
	}

	public void setParameter() {
		while (true) {
			try {
				chooseParameterScreen();
				int chosenParameterScreen = input.nextInt();
				if (chosenParameterScreen == 4)
					break;
				else if (chosenParameterScreen == 1) {
					inputParameter(ratedS);
				} else if (chosenParameterScreen == 2) {
					inputParameter(ratedR);
				} else if (chosenParameterScreen == 3) {
					inputParameter(ratedO);
				} else {
					System.out.println("Choose from 1 ~ 4");
				}
			} catch (InputMismatchException e) {
				e.getMessage();
				System.out.println();
				System.out.println("Numbers Only!");
				input.next();
				continue;
			}
		}
	}

	public void groupListScreen() {
		System.out.println();
		System.out.println("1. Several Times a Month" + "\t" + ": Rated S");
		System.out.println("2. Regularly, Once a Month" + "\t" + ": Rated R");
		System.out.println("3. Once a Year" + "\t\t\t" + ": Rated O");
		System.out.println("4. Go Back");
		System.out.println();
	}

	public void chooseParameterScreen() {
		System.out.println("=================     Input Group Parameter     =================");
		groupListScreen();
		System.out.println("=================================================================");
		System.out.println();
		System.out.print("Choose One : ");
	}

	public void inputParameter(Parameter p) throws InputMismatchException {
		while (true) {
			System.out.print("Determine Minimum Spent Time : ");
			p.minTime = input.nextInt();
			System.out.println();
			System.out.print("Determine Maximum Spent Time : ");
			p.maxTime = input.nextInt();
			System.out.println();
			if ((p.minTime >= 1) && (p.minTime < p.maxTime)) {
				System.out.println(p);
				System.out.println();
				break;
			} else {
				System.out.println("Minimum Time must be more than 0");
				System.out.println("Minimum Time must be less than Maximum Time");
				System.out.println();
			}
		}
	}

	public void inputCustomer() {
		while (true) {
			try {
				System.out.println("Enter -1 to Go Back");
				System.out.print("How Many Do You Have Customer For Segmentation : ");
				int size = input.nextInt();
				if (size == -1)
					break;
				else if (size == 0) {
					System.out.println();
					System.out.println("At least 1 or more...");
					System.out.println();
				}
				customers = new Customer[size];
				for (int i = 0; i < size; i++) {
					customers[i] = new Customer();
					inputCustomerData(i);
					sortGroup(i);
				}
			} catch (InputMismatchException e) {
				e.getMessage();
				System.out.println();
				System.out.println("Numbers Only!");
				System.out.println();
				input.next();
				continue;
			} catch (NegativeArraySizeException e) {
				e.getMessage();
				System.out.println();
				System.out.println("At least 1 or more...!");
				System.out.println();
				continue;
			}

		}
	}

	public void inputCustomerData(int i) {
		while (true) {
			try {
				System.out.println();
				System.out.printf("==============   %d  Input Customer's Information   ==============", i + 1);
				selectInfoScreen();
				int chosenInfoScreen = input.nextInt();
				if (chosenInfoScreen == 5)
					break;
				else if (chosenInfoScreen == 1)
					inputAge(i);
				else if (chosenInfoScreen == 2)
					selectGender(i);
				else if (chosenInfoScreen == 3)
					selectLocation(i);
				else if (chosenInfoScreen == 4)
					inputTime(i);
				else {
					System.out.println();
					System.out.println("Choose from 1 ~ 5");
					continue;
				}
			} catch (InputMismatchException e) {
				e.getMessage();
				System.out.println("Numbers Only!");
				input.next();
				continue;
			}
		}
	}

	public void selectInfoScreen() {
		System.out.println();
		System.out.println("=================================================================");
		System.out.println("1. Input Age");
		System.out.println("2. Select Gender");
		System.out.println("3. Select Location");
		System.out.println("4. Input Time Spent On Online (Per Month, mintue)");
		System.out.println("5. Go Back");
		System.out.println("=================================================================");
		System.out.println();
		System.out.print("Choose One : ");
		System.out.println();
	}

	public void inputAge(int i) {
		while (true) {
			try {
				System.out.print("Age : ");
				customers[i].age = input.nextInt();
			} catch (InputMismatchException e) {
				e.getMessage();
				System.out.println();
				System.out.println("Numbers Only!");
				System.out.println();
				input.next();
				continue;
			}
			if (customers[i].age >= 1 && customers[i].age <= 120)
				break;
			else {
				System.out.println();
				System.out.println("Age Cannot be Under 0 nor Over 120");
				System.out.println();
			}
		}
	}

	public void selectGender(int i) {
		while (true) {
			int chosenGender = 0;
			try {
				genderScreen();
				chosenGender = input.nextInt();
			} catch (InputMismatchException e) {
				e.getMessage();
				System.out.println();
				System.out.println("Numbers Only!");
				System.out.println();
				input.next();
				continue;
			}
			if (chosenGender == 1) {
				customers[i].gender = "Female";
				break;
			} else if (chosenGender == 2) {
				customers[i].gender = "Male";
				break;
			} else {
				System.out.println("Choose from 1 ~ 2");
				System.out.println();
			}
		}
	}

	public void genderScreen() {
		System.out.println("Gender");
		System.out.println();
		System.out.println("1. Female");
		System.out.println("2. Male");
		System.out.println();
		System.out.print("Choose One : ");
	}

	public void selectLocation(int i) {
		while (true) {
			int chosenLocation = 0;
			try {
				locationScreen();
				chosenLocation = input.nextInt();
			} catch (InputMismatchException e) {
				e.getMessage();
				System.out.println("Numbers Only!");
				System.out.println();
				input.next();
				continue;
			}
			if (chosenLocation == 1) {
				customers[i].location = "Asia";
			} else if (chosenLocation == 2) {
				customers[i].location = "Africa";
			} else if (chosenLocation == 3) {
				customers[i].location = "Europe";
			} else if (chosenLocation == 4) {
				customers[i].location = "Oceania";
			} else if (chosenLocation == 5) {
				customers[i].location = "North America";
			} else if (chosenLocation == 6) {
				customers[i].location = "South America";
			}
			if (chosenLocation >= 1 && chosenLocation <= 6) {
				break;
			} else {
				System.out.println("Choose from 1 ~ 6");
				System.out.println();
			}
		}
	}

	public void locationScreen() {
		System.out.println("Location");
		System.out.println();
		System.out.println("1. Asia");
		System.out.println("2. Africa");
		System.out.println("3. Europe");
		System.out.println("4. Oceania");
		System.out.println("5. North America");
		System.out.println("6. South America");
		System.out.println();
		System.out.print("Choose One : ");
	}

	public void inputTime(int i) {
		while (true) {
			try {
				System.out.println("Time Spent On Online (per month. min)");
				System.out.println();
				System.out.print("Time : ");
				customers[i].time = input.nextInt();
			} catch (InputMismatchException e) {
				e.getMessage();
				System.out.println();
				System.out.println("Numbers Only!");
				System.out.println();
				input.next();
				continue;
			}
			if (customers[i].time > 0)
				break;
			else {
				System.out.println();
				System.out.println("Must be Over 0");
				System.out.println();
			}
		}
	}

	public void viewCustomer() {
		while (true) {
			try {
				chooseViewScreen();
				int chosenViewScreen = input.nextInt();
				if (chosenViewScreen == 1) {
					displayList();
				} else if (chosenViewScreen == 2) {
					chooseGroupChart();
				} else if (chosenViewScreen == 3)
					break;
				else {
					System.out.println("Choose from 1 ~ 3");
					System.out.println();
				}
			} catch (InputMismatchException e) {
				e.getMessage();
				System.out.println("Numbers Only!");
				System.out.println();
				input.next();
				continue;
			} catch (NullPointerException e) {
				e.getMessage();
				System.out.println("No Data Saved!");
				System.out.println();
				continue;
			}
		}
	}

	public void chooseViewScreen() {
		System.out.println("================   View Customer's Information   ================");
		System.out.println();
		System.out.println("1. View as List");
		System.out.println("2. View as Chart");
		System.out.println("3. Go Back");
		System.out.println();
		System.out.println("=================================================================");
		System.out.println();
		System.out.print("Choose One : ");
	}

	public void displayList() {
		System.out.println();
		System.out.println("[list]");
		System.out.println();
		for (int i = 0; i < customers.length; i++) {
			System.out.printf("%d.  ", i + 1);
			sortGroup(i);
			System.out.println(customers[i]);
			System.out.println();
		}
	}

	public void chooseGroupViewScreen() {
		System.out.println();
		System.out.println("[Group Chart]");
		groupListScreen();
		System.out.print("Choose One : ");
		System.out.println();
	}

	public void sortGroup(int i) {
		if (customers[i].time >= ratedS.minTime && customers[i].time <= ratedS.maxTime) {
			customers[i].group = "Group S";
		} else if (customers[i].time >= ratedR.minTime && customers[i].time <= ratedR.maxTime) {
			customers[i].group = "Group R";
		} else if (customers[i].time >= ratedO.minTime && customers[i].time <= ratedO.maxTime) {
			customers[i].group = "Group O";
		} else {
			customers[i].group = null;
		}
	}

	public void chooseGroupChart() {
		while (true) {
			int chosenGroup = 0;
			int minTime, maxTime;
			try {
				chooseGroupViewScreen();
				chosenGroup = input.nextInt();
			} catch (InputMismatchException e) {
				e.getMessage();
				System.out.println("Numbers Only!");
				input.next();
				continue;
			}
			if (chosenGroup == 4)
				break;
			else if (chosenGroup == 1) {
				minTime = ratedS.minTime;
				maxTime = ratedS.maxTime;
			} else if (chosenGroup == 2) {
				minTime = ratedR.minTime;
				maxTime = ratedR.maxTime;
			} else if (chosenGroup == 3) {
				minTime = ratedO.minTime;
				maxTime = ratedO.maxTime;
			} else {
				System.out.println("Choose from 1 ~ 4");
				continue;
			}
			if ((minTime == -1) || (maxTime == -1)) {
				System.out.println("No Group Parameter Setted");
				continue;
			}
			displayChart(minTime, maxTime);
		}
	}

	public void displayChart(int minTime, int maxTime) {
		int[] ageAcc = null;
		int[] genderAcc = null;
		int[] locationAcc = null;
		for (int i = 0; i < customers.length; i++) {
			if ((customers[i].time >= minTime) && (customers[i].time <= maxTime)) {
				ageAcc = accumAge(i);
				genderAcc = accumGender(i);
				locationAcc = accumLocation(i);
			}
		}
		chartResult(ageAcc, genderAcc, locationAcc);
	}

	public int[] accumAge(int i) {
		int[] ageSum = { 0, 0, 0, 0, 0 };
		for (i = 0; i < customers.length; i++) {
			if (customers[i].age == 0)
				continue;
			if (customers[i].age <= 20) {
				ageSum[0]++;
			} else if (customers[i].age <= 40) {
				ageSum[1]++;
			} else if (customers[i].age <= 60) {
				ageSum[2]++;
			} else if (customers[i].age <= 80) {
				ageSum[3]++;
			} else
				ageSum[4]++;
		}
		return ageSum;
	}

	public int[] accumGender(int i) {
		int[] genSum = { 0, 0 };
		for (i = 0; i < customers.length; i++) {
			if (customers[i].gender == null)
				continue;
			if (customers[i].gender.equals("Female")) {
				genSum[0]++;
			} else
				genSum[1]++;
		}
		return genSum;
	}

	public int[] accumLocation(int i) {
		int[] locSum = { 0, 0, 0, 0, 0, 0 };
		for (i = 0; i < customers.length; i++) {
			if (customers[i].location == null)
				continue;
			if (customers[i].location.equals("Asia")) {
				locSum[0]++;
			} else if (customers[i].location.equals("Africa")) {
				locSum[1]++;
			} else if (customers[i].location.equals("Europe")) {
				locSum[2]++;
			} else if (customers[i].location.equals("Oceania")) {
				locSum[3]++;
			} else if (customers[i].location.equals("North America")) {
				locSum[4]++;
			} else
				locSum[5]++;
		}
		return locSum;
	}

	public void chartResult(int[] ageSum, int[] genSum, int[] locSum) {
		System.out.println();
		System.out.println("======================================================================");
		System.out.println();
		System.out.println("[Age]" + "\t\t\t" + "[Location]");
		System.out.println("(   ~ 20) : " + ageSum[0] + "\t\t" + "Asia : " + locSum[0]);
		System.out.println("(21 ~ 40) : " + ageSum[1] + "\t\t" + "Africa : " + locSum[1]);
		System.out.println("(41 ~ 60) : " + ageSum[2] + "\t\t" + "Europe : " + locSum[2]);
		System.out.println("(61 ~ 80) : " + ageSum[3] + "\t\t" + "Oceania : " + locSum[3]);
		System.out.println("(81 ~   ) : " + ageSum[4] + "\t\t" + "North America : " + locSum[4]);
		System.out.println("\t\t\t" + "South America : " + locSum[5]);
		System.out.println("[Gender]");
		System.out.println("Female : " + genSum[0] + "\t" + "Male : " + genSum[1]);
		System.out.println();
		System.out.println("======================================================================");
	}

	public void editCustomer() {
		while (true) {
			try {
				displayList();
				System.out.println("Enter -1 to Go Back");
				System.out.print("Choose one : ");
				int edit = input.nextInt();
				if (edit == -1)
					break;
				else if ((edit > customers.length) || (edit < 1)) {
					System.out.println();
					System.out.println("Choose from the List");
				} else {
					inputCustomerData(edit - 1);
					sortGroup(edit - 1);
				}
			} catch (InputMismatchException e) {
				e.getMessage();
				System.out.println();
				System.out.println("Numbers Only!");
				input.next();
				continue;
			} catch (NullPointerException e) {
				e.getMessage();
				System.out.println();
				System.out.println("No Data Saved!");
				break;
			}
		}
	}

}