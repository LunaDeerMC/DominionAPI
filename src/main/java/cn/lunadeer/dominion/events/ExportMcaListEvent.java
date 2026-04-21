package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.utils.McaRecord;

import java.util.List;

public class ExportMcaListEvent extends CallableEvent {

    private List<McaRecord> list;

    public ExportMcaListEvent(List<McaRecord> mcaRecords) {
        this.list = mcaRecords;
    }

    public List<McaRecord> getList() {
        return list;
    }

    public void setList(List<McaRecord> list) {
        this.list = list;
    }
}
