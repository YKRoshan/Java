package com.day8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Solution 1(Brute Force):
1.
2.
3.

Time Complexity: O()
Space Complexity: O()

Solution 2(Better):
1.
2.
3.
Time Complexity: O()
Space Complexity: O()

Solution 3(Optimal):
1.
2.
3.
Time Complexity: O()
Space Complexity: O()

*/
public class NMeetings {


    public static void main(String[] args) {
        int start[] = new int[]{1, 3, 0, 5, 8, 5};
        int end[] = new int[]{2, 4, 6, 7, 9, 9};
        Meeting meeting = new Meeting();
        meeting.maxMeetings(start, end, start.length);


    }
}

class MeetingVO {
    int start;
    int end;
    int pos;

    MeetingVO(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class meetingComparator implements Comparator<MeetingVO> {
    @Override
    public int compare(MeetingVO o1, MeetingVO o2) {
        if (o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        else if (o1.pos < o2.pos)
            return -1;
        return 1;
    }
}

class Meeting {
    void maxMeetings(int start[], int end[], int n) {
        ArrayList<MeetingVO> meet = new ArrayList<>();

        for (int i = 0; i < start.length; i++)
            meet.add(new MeetingVO(start[i], end[i], i + 1));

        meetingComparator mc = new meetingComparator();
        Collections.sort(meet, mc);
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(meet.get(0).pos);
        int limit = meet.get(0).end;

        for (int i = 1; i < start.length; i++) {
            if (meet.get(i).start > limit) {
                limit = meet.get(i).end;
                answer.add(meet.get(i).pos);
            }
        }

        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }
}

