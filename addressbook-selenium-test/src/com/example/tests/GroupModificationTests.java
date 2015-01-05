package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @Test(dataProvider = "randomValidGroupGenerator")
    public void modifySomeGroup(GroupData group) {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();

        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size());

        //actions
        app.getGroupHelper().initGroupModification(index);
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().gotoGroupsPage();

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        //compare states
        oldList.set(index, group);
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(newList, oldList);
    }
}