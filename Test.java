public class Test
{

	public static void main(String[] args)
	{
		Flight flight1 = new Flight(new AirBusSeatMap());
		// Flight flight1 = new Flight(new flight1SeatMap());
		RynoAir RA1 = new RynoAir();
		// SimpleJet RA1 = new SimpleJet();
		Seat seat = null;
		for (int i = 0; i < 5; i++)
		{

			RA1.reserveEconomy(flight1, SeatType.WINDOW);

		}

		for (int i = 0; i < 55; i++)
		{
			RA1.reserveFirstClass(flight1, SeatType.WINDOW);
			// SJ1.reserveEconomy(flight1, SeatType.WINDOW);

		}
		System.out.println(flight1.map);
		seat = flight1.map.getSeat(10, 'B');
		System.out.println(seat);
		Seat leftseat = flight1.map.getLeft(seat);
		System.out.println(leftseat);
		System.out.println(flight1.map);
	}

}
