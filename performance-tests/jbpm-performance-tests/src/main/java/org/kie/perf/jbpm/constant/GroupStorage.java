package org.kie.perf.jbpm.constant;

public enum GroupStorage {

    Engineering("engineering");
    
    private String groupId;
    
    private GroupStorage(String groupId) {
        this.groupId = groupId;
    }
    
    public String getGroupId() {
        return groupId;
    }
    
}
