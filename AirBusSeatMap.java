/*
 * AirBusSeatMap class is a subclass of SeatMap class
 * this class sets up different parts of an AirBus flight
 */
public class AirBusSeatMap extends SeatMap
{
	// the constructor sets basic info of an AirBus flight
	public AirBusSeatMap()
	{
		super(12, 'I', 6);
		initialiseSeatMap();
	}

	// initialise the seat type of an AirBus flight
	@Override
	public void initialiseSeatMap()
	{
		for (int i = 0; i < row; i++)
		{
			seat[i][2].setSeatType(SeatType.AISLE);
			seat[i][3].setSeatType(SeatType.AISLE);
			seat[i][5].setSeatType(SeatType.AISLE);
			seat[i][6].setSeatType(SeatType.AISLE);
			seat[i][0].setSeatType(SeatType.WINDOW);
			seat[i][8].setSeatType(SeatType.WINDOW);
			seat[i][1].setSeatType(SeatType.MIDDLE);
			seat[i][4].setSeatType(SeatType.MIDDLE);
			seat[i][7].setSeatType(SeatType.MIDDLE);
		}
	}
}