package com.team7.repository;

import com.team7.model.Community;
import com.team7.model.Survey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jbeckman on 10/29/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CommunityRepositoryTest {

    @Autowired
    private CommunityRepository communityRepository;

    @Test
    public void nothingInRepository() throws Exception {
        long count = StreamSupport.stream(communityRepository.findAll().spliterator(), false).count();
        assertThat(count).isEqualTo(0);
    }

    @Test
    public void communityIsAddedToRepository() throws Exception {
        long count = StreamSupport.stream(communityRepository.findAll().spliterator(), false).count();
        assertThat(count).isEqualTo(0);

        communityRepository.save(new Community("some region", "some county", "some name"));

        long countAfter = StreamSupport.stream(communityRepository.findAll().spliterator(), false).count();
        assertThat(countAfter).isEqualTo(1);
    }

    @Test
    public void queryWorks() throws Exception {
        long count = StreamSupport.stream(communityRepository.findAll().spliterator(), false).count();
        assertThat(count).isEqualTo(0);

        communityRepository.save(new Community("some region1", "asdfasdf", "some name1"));
        communityRepository.save(new Community("some region2", "some county2", "some name2"));
        communityRepository.save(new Community("some region3", "some county3", "asdf"));

        long countAfter = StreamSupport.stream(communityRepository.findByQuery("asdf").spliterator(), false).count();
        assertThat(countAfter).isEqualTo(2);
    }

}
