package adapters;

import modals.*;


public class ProjectAdapter extends BaseAdapter {
    public NegativeResponseStatus post(Project project, int statusCode) {
        String response = post(gson.toJson(project, Project.class), statusCode, "project/");
        return gson.fromJson(response, NegativeResponseStatus.class);
    }
    public PositiveResponsStatusForCreatProject post2(Project project, int statusCode) {
        String response = post(gson.toJson(project, Project.class), statusCode, "project/");
        return gson.fromJson(response, PositiveResponsStatusForCreatProject.class);
    }

    public NegativeResponseStatus getProjectFromNegativeResponse(int statusCode, String codeProject) {
        String response = super.get(statusCode, "project/" + codeProject);
        return gson.fromJson(response, NegativeResponseStatus.class);
    }
    public PositiveResponseStatus getProjectFromPositiveResponse(int statusCode, String codeProject) {
        String response = super.get(statusCode, "project/" + codeProject);
        return gson.fromJson(response, PositiveResponseStatus.class);
    }


}
