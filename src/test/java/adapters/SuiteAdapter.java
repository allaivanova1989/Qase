package adapters;
import modals.*;

public class SuiteAdapter extends BaseAdapter{
    public PositiveResponsStatusForSuite post(Suite suite, int statusCode, String codeProject) {
        String respone = post(gson.toJson(suite, Suite.class), statusCode, "suite/" + codeProject);
        return gson.fromJson(respone,PositiveResponsStatusForSuite.class);

    }

}
