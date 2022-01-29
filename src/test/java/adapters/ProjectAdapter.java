package adapters;

import modals.PositiveResponseStatus;
import modals.Project;
import modals.NegativeResponseStatus;

public class ProjectAdapter extends BaseAdapter {
    public NegativeResponseStatus post(Project project, int statusCode) {
        String response = post(gson.toJson(project, Project.class), statusCode, "project/");
        return gson.fromJson(response, NegativeResponseStatus.class);
    }

    public NegativeResponseStatus getProject(int statusCode, String codeProject) {
        String response = super.get(statusCode, "project/" + codeProject);
        return gson.fromJson(response, NegativeResponseStatus.class);
    }
    public PositiveResponseStatus getProject2(int statusCode, String codeProject) {
        String response = super.get(statusCode, "project/" + codeProject);
        return gson.fromJson(response, PositiveResponseStatus.class);
    }

//    public String delete(int statusCode) {
//        return delete(statusCode);
//    }
}
