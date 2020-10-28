package com.leagueanalysis;

import com.opencsv.bean.CsvBindByName;

public class CSVWickets {
	
	@CsvBindByName(column = "POS", required = true)
	public int position;

	@CsvBindByName(column = "PLAYER", required = true)
	public String player;

	@CsvBindByName(column = "Mat", required = true)
	public int matches;

	@CsvBindByName(column = "Inns", required = true)
	public int innings;

	@CsvBindByName(column = "Ov", required = true)
	public double overs;

	@CsvBindByName(column = "Runs", required = true)
	public int runs;

	@CsvBindByName(column = "Wkts", required = true)
	public int wickets;
	
	@CsvBindByName(column = "BBI", required = true)
	public int bbi;

	@CsvBindByName(column = "Avg", required = true)
	public double average;

	@CsvBindByName(column = "Econ", required = true)
	public double economy;

	@CsvBindByName(column = "SR", required = true)
	public double strikeRate;

	@CsvBindByName(column = "4w", required = true)
	public int fourWickets;

	@CsvBindByName(column = "5w", required = true)
	public int fiveWickets;

	@Override
	public String toString() {
		return "IPLWicketsCSV{" + "Position='" + position + '\'' + ", Player='" + player + '\'' + ", Matches='"
				+ matches + '\'' + ", Innings='" + innings + '\'' + ", Overs='" + overs + '\'' + ", Runs='" + runs
				+ '\'' + ", Wickets='" + wickets + '\'' + ", Average='" + average + ", Economy='" + economy + '\''
				+ ", Strike Rate='" + strikeRate + '\'' + ", 4w='" + fourWickets + '\'' + ", 5w='" + fiveWickets + '}';
	}

}
