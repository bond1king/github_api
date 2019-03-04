package com.bhargav;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.kohsuke.github.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by Bhargav on 04/03/2019.
 */
public class Profiler {

    //private final String username;
    //private HTTPClient client;


    public static List<GHRepository> getUserRepos(String username) throws IOException {
        List<GHRepository> ghRepositories = new ArrayList<>();
        GitHub github = GitHub.connect();
        GHUser user = github.getUser(username);
        Map<String, GHRepository> repositories = user.getRepositories();
        if(repositories != null){
            ghRepositories.addAll(repositories.values());
        }
        return ghRepositories;
    }


    public static List<GHRepository.Contributor> getContributors(GHRepository repository) throws IOException {
        List<GHRepository.Contributor> contributors = new ArrayList<>();
        PagedIterable<GHRepository.Contributor> contributorPagedIterable = repository.listContributors();
        PagedIterator<GHRepository.Contributor> iterator = contributorPagedIterable.iterator();
        while(iterator.hasNext()){
            contributors.add(iterator.next());
        }
        return contributors;
    }

//    private final String BASE_USER_URL="https://api.github.com/users/";
//    private final String USER_REPOS_URL="/repos";

    //Gets the list of repos of the user
    /*public List<Repository> getUserRepos(){
        List<Repository> repositories = new ArrayList<Repository>();
        String userRepoUrl = buildUserRepoUrl();
        String response = null;
        try {
            response = client.get(userRepoUrl);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        if(response!=null){
            JSONArray array = new JSONArray(response);
            if(array.length() > 0 ){
                System.out.println(  array.length() + " repositories found");
                for(Object repo : array) {
                    JSONObject repository = (JSONObject) repo;
                    try {
                        repositories.add(
                                new Repository(
                                        repository.getInt("id") + "",
                                        repository.getString("name"),
                                        repository.getString("full_name"),
                                        repository.getString("contributors_url")
                                )
                        );
                    } catch (JSONException ex) {
                        ex.printStackTrace();
                    }
                }
            } else {
                System.out.println("ZERO repsitories found");
            }
        }
        return repositories;
    }

    public Map<Contributor, Integer> getContributors(Repository repository) throws Exception{

        if(repository == null){
            throw new Exception("Repository cannot be null");
        }

        Map<Contributor, Integer> contributors = new HashMap<Contributor, Integer>();

        String contributorsUrl = repository.getContributorsURL();
        if(contributorsUrl == null){
            return contributors;
        } else {
            String response = null;
            try {
                response = client.get(contributorsUrl);
            } catch(IOException exception){
                throw exception;
            }
            if(response != null){
                JSONArray array = new JSONArray(response);
                if(array.length() > 0){
                    for(Object o : array) {
                        try {
                            JSONObject contribution = (JSONObject) o;
                            Contributor contributor = new Contributor(
                                    contribution.getInt("id") + "",
                                    contribution.getString("login")
                            );
                            contributors.put(contributor, contribution.getInt("contributions"));
                        } catch (JSONException jsException){
                            jsException.printStackTrace();
                        }
                    }
                }
            }
        }

        return contributors;
    }*/

    /*private String buildUserRepoUrl(){
        return BASE_USER_URL + username + USER_REPOS_URL;
    }*/
}
