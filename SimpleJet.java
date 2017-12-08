public class SimpleJet extends Airline
{
	public SimpleJet()
	{
		AirlineName = "SimpleJet";
	}

	@Override
	public Seat reserveFirstClass(Flight flight, SeatType type)
	{
		reserve = flight.map.queryAvailableFirstClassSeat(type);
		if (reserve != null)
		{
			flight.map.getSeat(reserve).setReserved();
			System.out.println(flight.map);
			System.out.println(reserve.getSeatPosition() + " has reserved for you.");
			System.out.println();
			return reserve;
		}
		Seat SearchStart = new Seat(flight.map.FirClassRow, 'A');
		while (reserve == null)
		{
			reserve = flight.map.queryAvailableEconomySeat(SeatType.MIDDLE, SearchStart);
			if (reserve.type != SeatType.MIDDLE)
			{
				System.out.println("No seats available for you!");
				return null;
			}
			if (!flight.map.getLeft(reserve).isReserved)
			{
				flight.map.getSeat(reserve).setReserved();
				flight.map.getLeft(reserve).setReserved();
				System.out.println(flight.map);
				System.out.println(flight.map.seat[reserve.getRow()][reserve.getCol() - 'A']);
				System.out.println(reserve.getSeatPosition() + " has reserved for you.");
				System.out.println();
				return reserve;
			}
			if (!flight.map.getRight(reserve).isReserved)
			{
				flight.map.getSeat(reserve).setReserved();
				flight.map.getRight(reserve).setReserved();
				System.out.println(flight.map);
				System.out.println(flight.map.seat[reserve.getRow()][reserve.getCol() - 'A']);
				System.out.println(reserve.getSeatPosition() + " has reserved for you.");
				System.out.println();
				return reserve;
			}
			SearchStart = reserve;
			reserve = null;
		}
		System.out.println("No seat for you");
		return reserve;
	}

	@Override
	public Seat reserveEconomy(Flight flight, SeatType type)
	{
		reserve = flight.map.queryAvailableEconomySeat(type, new Seat(flight.map.FirClassRow, (char) ('A' - 1)));
		if (reserve != null)
		{
			flight.map.getSeat(reserve).setReserved();
			System.out.println(flight.map);
			System.out.println(flight.map.seat[reserve.getRow()][reserve.getCol() - 'A']);
			System.out.println(reserve.getSeatPosition() + " has reserved for you.");
			System.out.println();
		}
		return reserve;
	}
}
