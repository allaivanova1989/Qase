package adapters;
import modals.*;

public class ProjectAdapter extends BaseAdapter {
    public NegativeResponseStatus postWithIncorrectData(Project project, int statusCode) {
        String response = post(gson.toJson(project, Project.class), statusCode, "project/");
        return gson.fromJson(response, NegativeResponseStatus.class);
    }
    public PositiveResponsStatusForCreatProject postWithCorrectData(Project project, int statusCode) {
        String response = post(gson.toJson(project, Project.class), statusCode, "project/");
        return gson.fromJson(response, PositiveResponsStatusForCreatProject.class);
    }

    public NegativeResponseStatus getProjectWithIncorrectCode(int statusCode, String codeProject) {
        String response = super.get(statusCode, "project/" + codeProject);
        return gson.fromJson(response, NegativeResponseStatus.class);
    }
    public PositiveResponseStatus getProjectWithCorrectCode(int statusCode, String codeProject) {
        String response = super.get(statusCode, "project/" + codeProject);
        return gson.fromJson(response, PositiveResponseStatus.class);
    }
    public PositiveResponsStatusForCreatProject deleteProjectByCorrectCode(int statusCode, String codeProject) {
        String response = super.delete(statusCode, "project/" + codeProject);
        return gson.fromJson(response, PositiveResponsStatusForCreatProject.class);
    }


}
