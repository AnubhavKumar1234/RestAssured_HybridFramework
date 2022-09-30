package GenericLibraries;
/**
 * This interface will contain all the endpoints
 * @author anubhav
 *
 */

public interface EndPointsLibrary 
{
	String createProject="/addProject";
	String getAllProjects="/projects";
	String getSingleProject="/projects/";
	String deleteProject="/projects/";
	String updateProject="/projects/";

}
