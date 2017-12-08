public abstract class Airline
{
	protected String AirlineName = new String();
	protected Seat reserve = null;

	public abstract Seat reserveFirstClass(Flight flight, SeatType type);

	public abstract Seat reserveEconomy(Flight flight, SeatType type);

	public String getAirLineName()
	{
		return AirlineName;
	}

	public void setAirLineName(String airlineName)
	{
		AirlineName = airlineName;
	}

	public String toString()
	{
		return "Welcome to " + AirlineName + " Airline reservation system";
	}
}
