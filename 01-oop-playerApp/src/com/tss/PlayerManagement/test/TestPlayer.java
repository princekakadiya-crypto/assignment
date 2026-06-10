package com.tss.PlayerManagement.test;

import com.tss.PlayerManagement.entity.Player;
import com.tss.Validation.InputValidation;

import java.util.Scanner;

public class TestPlayer {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Player[] players=new Player[3];
        for(int i=0;i<players.length;i++) {
            players[i] = new Player();
            System.out.println("\nEnter Details for player "+(i+1)+"\n");
            players[i].setId(InputValidation.readInt("Enter ID : "));
            players[i].setName(InputValidation.readName("Enter Name : "));
            players[i].setNumberOfMatchas(InputValidation.readInt("Enter Number Of Matchas : ", 0));
            players[i].setRuns(InputValidation.readInt("Enter Runs : ", 0));
            players[i].setWickets(InputValidation.readInt("Enter Wicket : ", 0));
        }

        System.out.println("ID\tName\t\tMatch\t\tRuns\t\tWicket\t\tAverage");
        for(int i=0;i<players.length;i++) {
            System.out.println(players[i].getId()+"\t"+players[i].getName()+"\t\t"+players[i].getNumberOfMatchas()+"\t\t\t"+players[i].getRuns()+"\t\t\t"+players[i].getWickets()+"\t\t\t"+players[i].calculateAverage());
        }
    }
}
