package com.leagueanalysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;

import gradleAssignment.CSVBuilderException;
import gradleAssignment.CSVBuilderFactory;
import gradleAssignment.CSVBuilderInterface;

public class IPLAnalysis {
	
	List<CSVRuns> csvRunsList = null;
	List<CSVWickets> csvWktsList = null;

	public int loadDataOfRuns(String CSVFile) throws IOException, CSVBuilderException {
		Reader reader = Files.newBufferedReader(Paths.get(CSVFile));
		@SuppressWarnings("unchecked")
		CSVBuilderInterface<CSVRuns> csvBuilder = CSVBuilderFactory.createCSVBuilder();
		csvRunsList = csvBuilder.getCSVFileList(reader, CSVRuns.class);
		return csvRunsList.size();		
	}

	public int loadDataOfWickets(String CSVFile) throws IOException, CSVBuilderException {
		Reader reader = Files.newBufferedReader(Paths.get(CSVFile));
		@SuppressWarnings("unchecked")
		CSVBuilderInterface<CSVWickets> csvBuilder = CSVBuilderFactory.createCSVBuilder();
		csvWktsList = csvBuilder.getCSVFileList(reader, CSVWickets.class);
		return csvWktsList.size();
	}
	
	/**
	 * UC 1
	 * 
	 * @return
	 * @throws CSVBuilderException
	 * @throws IOException
	 */
	public double getTopBattingAvg() throws CSVBuilderException, IOException {
		double max = csvRunsList.stream().map(CSVRuns -> CSVRuns.average).max(Double::compare).get();
		return max;
	}
	
	public String getAverageWiseSortedData() {
		Comparator<CSVRuns> comparator = Comparator.comparing(entry -> entry.average);
		this.sort(csvRunsList, comparator);
		String sorted = new Gson().toJson(csvRunsList);
		return sorted;
	}
	
	public String getSRWiseSortedData() {
		Comparator<CSVRuns> comparator = Comparator.comparing(entry -> entry.strikeRate);
		this.sort(csvRunsList, comparator);
		String sorted = new Gson().toJson(csvRunsList);
		return sorted;
	}

	public <E> void sort(List<E> csvList, Comparator<E> comparator) {
		for (int i = 0; i < csvList.size(); i++) {
			for (int j = 0; j < csvList.size() - i - 1; j++) {
				E player1 = csvList.get(j);
				E player2 = csvList.get(j + 1);
				if (comparator.compare(player1, player2) < 0) {
					csvList.set(j, player2);
					csvList.set(j + 1, player1);
				}
			}
		}
	}
}
