import java.util.Scanner;

public class AirlineReservationApplication
{
	Scanner scan = new Scanner(System.in);

	public void chooseSeat(Airline air, Flight flight)
	{
		int choice = 0;
		System.out.println(air);
		System.out.println(flight);
		System.out.println("1. Reserve First Class\n2. Reserve Economy Class\n3. Show Seating Map\n4. Quit");
		choice = scan.nextInt();
		if (choice == 1)
		{
			System.out.println("Which seat type?\n1. AISLE\n2. MIDDLE\n3. WINDOW");
			choice = scan.nextInt();
			if (choice == 1)
			{
				air.reserveFirstClass(flight, SeatType.AISLE);
			}
			else if (choice == 2)
			{
				air.reserveFirstClass(flight, SeatType.MIDDLE);
			}
			else if (choice == 3)
			{
				air.reserveFirstClass(flight, SeatType.WINDOW);
			}
		}
		else if (choice == 2)
		{
			System.out.println("Which seat type?\n1. AISLE\n2. MIDDLE\n3. WINDOW");
			choice = scan.nextInt();
			if (choice == 1)
			{
				air.reserveEconomy(flight, SeatType.AISLE);
			}
			else if (choice == 2)
			{
				air.reserveEconomy(flight, SeatType.MIDDLE);
			}
			else if (choice == 3)
			{
				air.reserveEconomy(flight, SeatType.WINDOW);
			}
		}
		else if (choice == 3)
		{
			System.out.println(flight.map);
		}
		else if (choice == 4)
		{
			System.out.println("Goodbye!");
		}

	}

	public static void main(String[] args)
	{
		AirlineReservationApplication app = new AirlineReservationApplication();
		Flight flightsj1 = new Flight(new AirBusSeatMap());
		Flight flightra1 = new Flight(new AirBusSeatMap());
//		Flight flightsj2 = new Flight(new BoeingSeatMap());
//		Flight flightra2 = new Flight(new BoeingSeatMap());
		SimpleJet sj1 = new SimpleJet();
		//SimpleJet sj2 = new SimpleJet();
		RynoAir ra1 = new RynoAir();
		//RynoAir ra2 = new RynoAir();
		flightsj1.setFlightNo("SJ001");
		flightsj1.setStartCity("Auckland");
		flightsj1.setDestCity("Sydney");
		flightsj1.setDeparTime("16:00h");
/*		flightsj2.setFlightNo("SJ002");
		flightsj2.setStartCity("Sydney");
		flightsj2.setDestCity("Auckland");
		flightsj2.setDeparTime("6:00h");*/
		flightra1.setFlightNo("RA001");
		flightra1.setStartCity("Auckland");
		flightra1.setDestCity("Shanghai");
		flightra1.setDeparTime("18:00h");
/*		flightra2.setFlightNo("RA002");
		flightra2.setStartCity("Shanghai");
		flightra2.setDestCity("Auckland");
		flightra2.setDeparTime("8:00h");*/
		app.chooseSeat(sj1, flightsj1);
		//app.chooseSeat(sj2, flightsj2);
		app.chooseSeat(ra1, flightra1);
		//app.chooseSeat(ra2, flightra2);
		app.scan.close();
	}
}
