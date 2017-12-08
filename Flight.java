public class Flight
{
	private String startCity, destCity, deparTime, flightNo;
	protected SeatMap map;

	public Flight(SeatMap map)
	{
		if (map.FirClassRow == 6)
		{
			this.map = new AirBusSeatMap();
		}
		else
		{
			this.map = new BoeingSeatMap();
		}
	}

	public String getStartCity()
	{
		return startCity;
	}

	public void setStartCity(String startCity)
	{
		this.startCity = startCity;
	}

	public String getDestCity()
	{
		return destCity;
	}

	public void setDestCity(String destCity)
	{
		this.destCity = destCity;
	}

	public String getDeparTime()
	{
		return deparTime;
	}

	public void setDeparTime(String deparTime)
	{
		this.deparTime = deparTime;
	}

	public String getFlightNo()
	{
		return flightNo;
	}

	public void setFlightNo(String flightNo)
	{
		this.flightNo = flightNo;
	}

	public String toString()
	{
		return "Booking seats for Flight: " + flightNo + " from: " + startCity + " to: " + destCity + " departing: "
				+ deparTime;
	}
}