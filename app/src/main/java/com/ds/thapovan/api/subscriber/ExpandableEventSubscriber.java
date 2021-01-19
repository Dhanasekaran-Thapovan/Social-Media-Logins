package com.ds.thapovan.api.subscriber;

import com.ds.thapovan.expandable_response.ExpandableApiResponse;

public interface ExpandableEventSubscriber {
    void onExpandableResponse(ExpandableApiResponse response);
}
