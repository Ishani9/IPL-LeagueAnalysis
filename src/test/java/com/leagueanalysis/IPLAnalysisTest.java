package com.leagueanalysis;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

import gradleAssignment.CSVBuilderException;

public class IPLAnalysisTest {
	
	public static String RUNS_FILE = "C:\\Users\\Ishani\\eclipse-workspace\\com.leagueanalysis\\MostRuns";
	public static String WICKETS_FILE = "C:\\Users\\Ishani\\eclipse-workspace\\com.leagueanalysis\\MostWkts";
	IPLAnalysis iplAnalysis;
	
	@Before
	public void setUp() throws CSVBuilderException, IOException {
		iplAnalysis = new IPLAnalysis();
	}

	
	@Test
	public void givenFileData_IfMatchNumberOfRecords_ShouldReturnTrue() {
		try {
			int count = iplAnalysis.loadDataOfRuns(RUNS_FILE);
			assertEquals(101, count);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (CSVBuilderException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void givenWKTSFileData_IfMatchNumberOfRecords_ShouldReturnTrue() {
		try {
			int count = iplAnalysis.loadDataOfWickets(WICKETS_FILE);
			assertEquals(99, count);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (CSVBuilderException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * UC 1
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 */
	@Test
	public void givenRunsData_WhenSortedOnAverage_ShouldReturnHighest() throws IOException, CSVBuilderException {
		try {
			iplAnalysis.loadDataOfRuns(RUNS_FILE);
			Double sortedCSVData = iplAnalysis.getTopBattingAvg();
			Double exp = 83.2;
			assertEquals(exp, sortedCSVData);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
	}

	@Test
	public void givenRunsData_WhenSortedOnAverage_ShouldReturnTrue() throws IOException, CSVBuilderException {
		try {
			iplAnalysis.loadDataOfRuns(RUNS_FILE);
			String sortedCSVData = iplAnalysis.getAverageWiseSortedData();
			CSVRuns[] iplCSV = new Gson().fromJson(sortedCSVData, CSVRuns[].class);
			assertEquals(83.2, iplCSV[0].average, 0.0);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * UC 2
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 */
	@Test
	public void givenRunsData_WhenSortedOnSR_ShouldReturnTrue() throws IOException, CSVBuilderException {
		try {
			iplAnalysis.loadDataOfRuns(RUNS_FILE);
			String sortedCSVData = iplAnalysis.getSRWiseSortedData();
			CSVRuns[] iplCSV = new Gson().fromJson(sortedCSVData, CSVRuns[].class);
			assertEquals(333.33, iplCSV[0].strikeRate, 0.0);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 	
	}
	
	/**
	 * UC 3
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 */
	@Test
	public void givenRunsData_WhenSortedOn6And4_ShouldReturnTrue() throws IOException, CSVBuilderException {
		try {
			iplAnalysis.loadDataOfRuns(RUNS_FILE);
			String sortedCSVData = iplAnalysis.getMax6And4WiseSortedData();
			CSVRuns[] iplCSV = new Gson().fromJson(sortedCSVData, CSVRuns[].class);
			assertEquals("Andre Russell", iplCSV[0].player);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 	
	}
	
	@Test
	public void givenRunsData_WhenSortedOnSixes_ShouldReturnTrue() throws IOException, CSVBuilderException {
		try {
			iplAnalysis.loadDataOfRuns(RUNS_FILE);
			String sortedCSVData = iplAnalysis.getMax6WiseSortedData();
			CSVRuns[] iplCSV = new Gson().fromJson(sortedCSVData, CSVRuns[].class);
			assertEquals("Andre Russell", iplCSV[0].player);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 	
	}
	
	@Test
	public void givenRunsData_WhenSortedOnFours_ShouldReturnTrue() throws IOException, CSVBuilderException {
		try {
			iplAnalysis.loadDataOfRuns(RUNS_FILE);
			String sortedCSVData = iplAnalysis.getMax4WiseSortedData();
			CSVRuns[] iplCSV = new Gson().fromJson(sortedCSVData, CSVRuns[].class);
			assertEquals("Shikhar Dhawan", iplCSV[0].player);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 	
	}
	
	/**
	 * UC 4
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 */
	@Test
	public void givenRunsData_WhenSortedOn6And4AndSR_ShouldReturnTrue() throws IOException, CSVBuilderException {
		try {
			iplAnalysis.loadDataOfRuns(RUNS_FILE);
			String sortedCSVData = iplAnalysis.getMax6And4AndSRWiseSortedData();
			CSVRuns[] iplCSV = new Gson().fromJson(sortedCSVData, CSVRuns[].class);
			assertEquals("Ishant Sharma", iplCSV[0].player);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 	
	}
	
	/**
	 * UC 5
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 */
	@Test
	public void givenRunsData_WhenSortedOnAverageAndStrikeRate_ShouldReturnTrue()
			throws IOException, CSVBuilderException {
		try {
			iplAnalysis.loadDataOfRuns(RUNS_FILE);
			String sortedCSVData = iplAnalysis.getSortedOnAverageAndStrikeRate();
			CSVRuns[] iplCSV = new Gson().fromJson(sortedCSVData, CSVRuns[].class);
			assertEquals("MS Dhoni", iplCSV[0].player);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 	
	}
	
	/**
	 * UC 6
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 */
	@Test
	public void givenRunsData_WhenSortedOnMaxRunsAndAverage_ShouldReturnTrue()
			throws IOException, CSVBuilderException {
		try {
			iplAnalysis.loadDataOfRuns(RUNS_FILE);
			String sortedCSVData = iplAnalysis.getSortedOnMaxRunsAndAverage();
			CSVRuns[] iplCSV = new Gson().fromJson(sortedCSVData, CSVRuns[].class);
			assertEquals("David Warner", iplCSV[0].player);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 	
	}
	
	/**
	 * UC 7
	 * 
	 * @throws IOException
	 * @throws CSVBuilderException
	 */
	@Test
	public void givenWktsData_WhenSortedOnBowlingAvg_ShouldReturnTrue()
			throws IOException, CSVBuilderException {
		try {
			iplAnalysis.loadDataOfRuns(WICKETS_FILE);
			String sortedCSVData = iplAnalysis.sortedOnBowlingAverage();
			CSVWickets[] iplCSV = new Gson().fromJson(sortedCSVData, CSVWickets[].class);
			assertEquals("Anukul Roy", iplCSV[0].player);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	@Test
	public void givenWktsData_WhenSortedOnBowlingAvg_ShouldReturnTopAverage()
			throws IOException, CSVBuilderException {
		try {
			iplAnalysis.loadDataOfRuns(WICKETS_FILE);
			String sortedCSVData = iplAnalysis.sortedOnBowlingAverage();
			CSVWickets[] iplCSV = new Gson().fromJson(sortedCSVData, CSVWickets[].class);
			assertEquals(11.0, iplCSV[0].average, 0.0);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
}

	
	