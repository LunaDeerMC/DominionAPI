package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.utils.McaRecord;

import java.util.List;

/**
 * Fired when Dominion exports the MCA whitelist.
 * <p>
 * Listeners can inspect or replace the list before the export is consumed.
 */
public class ExportMcaListEvent extends CallableEvent {

    private List<McaRecord> list;

    /**
     * Creates an MCA whitelist export event.
     *
     * @param mcaRecords the initial MCA records
     */
    public ExportMcaListEvent(List<McaRecord> mcaRecords) {
        this.list = mcaRecords;
    }

    /**
     * Gets the current MCA records.
     *
     * @return the current record list
     */
    public List<McaRecord> getList() {
        return list;
    }

    /**
     * Replaces the MCA records carried by this event.
     *
     * @param list the replacement record list
     */
    public void setList(List<McaRecord> list) {
        this.list = list;
    }
}
