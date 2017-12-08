/*
 * Seat class is to store info of a seat on planes
 * @isReserved is to store if the seat has been reserved
 * @isFirClass is to store if the seat is a first class seat
 * @SeatPosition is the position of a seat
 * @type is the type a the seat (aisle, middle or window)
 */
public class Seat
{
	boolean isReserved = false;
	boolean isFirClass = false;
	String SeatPosition = new String();
	SeatType type;
	int row;
	char col;

	private void InitData()
	{
		row = 0;
		col = 0;
	}

	/*
	 * constructor sets up the position of a seat
	 */
	public Seat(int row, char col)
	{
		this.row = row;
		this.col = col;
		setSeatPosition(row, col);
	}

	public String getSeatPosition()
	{
		return SeatPosition;
	}

	public void setSeatPosition(int row, char col)
	{
		SeatPosition += row + 1;
		SeatPosition += col;
	}

	public int getRow()
	{
		return row;
	}

	public char getCol()
	{
		return col;
	}

	// to set a seat reserved
	public void setReserved()
	{
		isReserved = true;
	}

	// to set a seat first class
	public void setisFirclass(boolean isFirClass)
	{
		this.isFirClass = isFirClass;
	}

	// to the seat type of a seat
	public void setSeatType(SeatType type)
	{
		this.type = type;
	}

	// return a description of the seat
	public String toString()
	{
		String seat = new String();
		if (isFirClass)
		{
			seat += "First Class";
		}
		else
		{
			seat += "Economy Class ";
		}
		seat += type.name() + " seat at: " + getSeatPosition();
		if (isReserved)
		{
			seat += " is " + "reserved.";
		}
		else
		{
			seat += " is not reserved.";
		}
		return seat;
	}
}