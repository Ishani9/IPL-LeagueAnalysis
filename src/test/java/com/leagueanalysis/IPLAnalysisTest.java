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
	public void setUp() {
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

	@SuppressWarnings("deprecation")
	@Test
	public void givenRunsData_WhenSortedOnAverage_ShouldReturnTrue() throws IOException, CSVBuilderException {
		try {
			iplAnalysis.loadDataOfRuns(RUNS_FILE);
			String sortedCSVData = iplAnalysis.getAverageWiseSortedData();
			CSVRuns[] iplCSV = new Gson().fromJson(sortedCSVData, CSVRuns[].class);
			assertEquals(83.2, iplCSV[0].average);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
}

	
	