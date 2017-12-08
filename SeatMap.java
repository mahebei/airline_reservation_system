/*
 * SeatMap class is to provide a template of different flights
 * @row is the total num of row of the airplane
 * @column is the total num of column of the airplane
 * @FirClassRow is the total num of first class row
 * @seat[][] is the array of all the seats of the airplane
 */
public abstract class SeatMap
{
	protected int row;
	protected char column;
	protected int FirClassRow;
	protected Seat seat[][];

	/*
	 * constructor sets row, column, FirClassRow initialise all seats and set if is
	 * first class
	 */
	public SeatMap(int row, char column, int FirClassRow)
	{
		this.row = row;
		this.column = column;
		this.FirClassRow = FirClassRow;
		seat = new Seat[row][column - 'A' + 1];
		for (int i = 0; i < row; i++)
		{
			for (char j = 'A'; j <= column; j++)
			{
				seat[i][j - 'A'] = new Seat(i, j);
				if (row < FirClassRow)
				{
					seat[i][j - 'A'].setisFirclass(true);
				}
			}
		}
	}

	public abstract void initialiseSeatMap();

	// return the last row of the plane
	public int getLastRow()
	{
		return row;
	}

	// return the last column of the plane
	public char getLastColumn()
	{
		return column;
	}

	// returns the current seat
	public Seat getSeat(Seat seat)
	{
		return this.seat[seat.getRow()][seat.getCol() - 'A'];
	}

	public Seat getSeat(int row, char col)
	{
		return this.seat[row - 1][col - 'A'];
	}

	// returns the left of current seat, if unavailable return null
	public Seat getLeft(Seat seat)
	{
		if (seat.getCol() > 'A')
		{
			return this.seat[seat.getRow()][seat.getCol() - 'A' - 1];
		}
		else
		{
			System.out.println("Seat unavailable");
			return null;
		}
	}

	// returns the right of current seat, if unavailable return null
	public Seat getRight(Seat seat)
	{
		if (seat.getCol() < column)
		{
			return this.seat[seat.getRow()][seat.getCol() - 'A' + 1];
		}
		else
		{
			System.out.println("Seat unavailable");
			return null;
		}
	}

	/*
	 * get a economy seat of certain type, if is unavailable, return any seat in
	 * economy. If all seats are reserved, return null.
	 */
	public Seat queryAvailableEconomySeat(SeatType type, Seat SearchStartSeat)
	{
		for (int j = SearchStartSeat.getCol() - 'A' + 1; j <= column - 'A'; j++)
		{
			if (!seat[SearchStartSeat.getRow()][j].isReserved && seat[SearchStartSeat.getRow()][j].type.equals(type))
			{
				return seat[SearchStartSeat.getRow()][j];
			}
		}
		for (int i = SearchStartSeat.getRow() + 1; i < row; i++)
		{
			for (int j = 0; j <= column - 'A'; j++)
			{
				if (!seat[i][j].isReserved && seat[i][j].type.equals(type))
				{
					return seat[i][j];
				}
			}
		}
		for (int i = FirClassRow; i < row; i++)
		{
			for (char j = 'A'; j <= column; j++)
			{
				if (!seat[i][j - 'A'].isReserved)
				{
					return seat[i][j - 'A'];
				}
			}
		}
		return null;
	}

	/*
	 * get a first class seat of certain type, if is unavailable, return any seat in
	 * first class. If all seats are reserved, return null.
	 */
	public Seat queryAvailableFirstClassSeat(SeatType type)
	{
		for (int i = 0; i < FirClassRow; i++)
		{
			for (char j = 'A'; j <= column; j++)
			{
				if (!seat[i][j - 'A'].isReserved && seat[i][j - 'A'].type.equals(type))
				{
					return seat[i][j - 'A'];
				}
			}
		}

		for (int i = 0; i < FirClassRow; i++)
		{
			for (char j = 'A'; j <= column; j++)
			{
				if (!seat[i][j - 'A'].isReserved)
				{
					return seat[i][j - 'A'];
				}
			}
		}
		return null;
	}

	// return a seat map
	public String toString()
	{
		String map = "    ";
		for (char j = 'A'; j <= column; j++)
		{
			map += j + "      ";
		}
		map += "\n";
		for (int i = 0; i < FirClassRow; i++)
		{
			map += " " + (i + 1);
			for (char j = 'A'; j <= column; j++)
			{
				map += " [";
				map += seat[i][j - 'A'].type.name().charAt(0);
				if (seat[i][j - 'A'].isReserved)
				{
					map += " X ]";
				}
				else
				{
					map += " _ ]";
				}
			}
			map += "\n";
		}
		for (int i = FirClassRow; i < row; i++)
		{
			if (i + 1 > 9)
			{
				map += (i + 1);
			}
			else
			{
				map += " " + (i + 1);
			}
			for (char j = 'A'; j <= column; j++)
			{
				map += " [";
				map += Character.toLowerCase((seat[i][j - 'A'].type.name().charAt(0)));
				if (seat[i][j - 'A'].isReserved)
				{
					map += " X ]";
				}
				else
				{
					map += " _ ]";
				}
			}
			map += "\n";
		}
		return map;
	}
}