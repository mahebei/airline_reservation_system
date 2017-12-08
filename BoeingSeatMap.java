/*
 * BoeingSeatMap class is a subclass of SeatMap class
 * this class sets up different parts of a boeing flight
 */
public class BoeingSeatMap extends SeatMap
{
	// the constructor sets basic info of a boeing flight
	public BoeingSeatMap()
	{
		super(10, 'G', 4);
		initialiseSeatMap();
	}

	// initialise the seat type of a Boeing flight
	@Override
	public void initialiseSeatMap()
	{
		for (int i = 0; i < row; i++)
		{
			seat[i][1].setSeatType(SeatType.AISLE);
			seat[i][2].setSeatType(SeatType.AISLE);
			seat[i][4].setSeatType(SeatType.AISLE);
			seat[i][5].setSeatType(SeatType.AISLE);
			seat[i][0].setSeatType(SeatType.WINDOW);
			seat[i][6].setSeatType(SeatType.WINDOW);
			seat[i][3].setSeatType(SeatType.MIDDLE);
		}
	}
}