package com.bhargav;

import org.kohsuke.github.GHRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by Bhargav on 04/03/2019.
 */
public class Runner {

    public static void main(String[] args)  throws Exception{
        if(args.length == 0){
            System.out.println("No username specified");
            return;
        }
        String username = args[0];

        List<GHRepository> repositoryList = Profiler.getUserRepos(username);

        for(GHRepository repository : repositoryList){
            System.out.println("Repository " +  repository.getFullName());
            try {
                List<GHRepository.Contributor> contributorList= Profiler.getContributors(repository);
                contributorList.sort(new Comparator<GHRepository.Contributor>() {
                    @Override
                    public int compare(GHRepository.Contributor o1, GHRepository.Contributor o2) {
                        if( o1.getContributions() > o2.getContributions()){
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                });

                for(GHRepository.Contributor contributor : contributorList){
                    System.out.println("\t Contributor - "
                            + contributor.getLogin()
                            + " has contributed " + contributor.getContributions() + " times");
                }
            } catch ( Exception e ){
                e.printStackTrace();
            }
        }
    }
}
