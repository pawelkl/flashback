/*
 * Copyright 2012 Daniel Jarvis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.co.danieljarvis.android.flashback;

import java.util.Comparator;

/**
 * Holds SMS messages and call list items for display in toast
 */
public class ToastListItem implements Comparator<ToastListItem> {
    // If this is a call list item, then was it a missed, incoming or outgoing call
    int mCallType = -1;

    // Only applies if this is an SMS message
    String mMsgText = null;

    // If this is an SMS message, then this shows if it is an inbox message, if
    // false then this is a sent message
    boolean mIsInboxMsg = true;

    long mTimeOfArrival;

    public ToastListItem(long xiTimeOfArrival, String xiText, boolean xiIsInboxMsg, int xiCallType) {
        mTimeOfArrival = xiTimeOfArrival;
        mMsgText = xiText;
        mIsInboxMsg = xiIsInboxMsg;
        mCallType = xiCallType;
    }

    public int compare(ToastListItem object1, ToastListItem object2) {
        Long long1 = new Long(object1.mTimeOfArrival);
        Long long2 = new Long(object2.mTimeOfArrival);

        // We want the reverse order so the newest info is at the top
        return long2.compareTo(long1);
    }
}