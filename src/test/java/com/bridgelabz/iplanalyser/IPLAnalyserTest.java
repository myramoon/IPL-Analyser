package com.bridgelabz.iplanalyser;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import com.bridgelabz.csvreader.CensusAnalyserException;
import com.google.gson.Gson;

public class IPLAnalyserTest {
    private static final String MOST_RUNS_DATA = "/Users/nusrat/IdeaProjects/IPL-Analyser/src/test/resources/WP DP Data_01 IPL2019FactsheetMostRuns.csv" ;

    @Test
    public void givenBatsmenRunDetails_WhenCalculated_ShouldReturnMaximumBattingAverage()
    {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            String sortedBattingAverage = iplAnalyser.givenRunsAverageSortedDetails(MOST_RUNS_DATA);
            MostRuns[] mostBattingAverage = new Gson().fromJson( sortedBattingAverage, MostRuns[].class);
            Assert.assertEquals("MS Dhoni",mostBattingAverage[0].player);
        } catch (CensusAnalyserException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void givenBatsmenRunDetails_WhenCalculated_ShouldReturnMaximumStrikeRate()
    {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            String sortedStrikeRate = iplAnalyser.givenStrikeRateSortedDetails(MOST_RUNS_DATA);
            MostRuns[] mostStrikeRate = new Gson().fromJson( sortedStrikeRate, MostRuns[].class);
            Assert.assertEquals("Ishant Sharma",mostStrikeRate[0].player);
        } catch (CensusAnalyserException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
