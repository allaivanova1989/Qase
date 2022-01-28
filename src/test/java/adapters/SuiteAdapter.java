package adapters;


public class SuiteAdapter extends BaseAdapter{
    public String post(String body, int statusCode, String codeProject) {
        return super.post(body,statusCode,"suite/" + codeProject);


    }

}
