/*
package com.batch.config;

import com.batch.model.User;
import com.batch.repository.UserRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private UserRepository userRepository;

    @Bean
    public FlatFileItemReader<User> reader(){
        FlatFileItemReader<User> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("SpringBatchCsvSheet.csv"));
        reader.setLineMapper(getLineMapper());
        reader.setLinesToSkip(0);
        return reader;
    }

    private LineMapper<User> getLineMapper() {
        DefaultLineMapper<User> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokeniser = new DelimitedLineTokenizer();
        lineTokeniser.setNames(new String[]{"FirstName","LastName","City","Ph"});
        lineTokeniser.setIncludedFields(new int[]{0,1,2,3});

        BeanWrapperFieldSetMapper fieldSetter = new BeanWrapperFieldSetMapper<>();
        fieldSetter.setTargetType(User.class);


        lineMapper.setLineTokenizer(lineTokeniser);
        lineMapper.setFieldSetMapper(fieldSetter);

        return lineMapper;
    }

    @Bean
    public UserItemProcessor processor(){
        return new UserItemProcessor();
    }


    //this method uses Jdbc, where you need to write the whole quesry by yourself
   */
/* @Bean
    public JdbcBatchItemWriter<User> writer(){
        JdbcBatchItemWriter<User> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<User>());
        writer.setSql("INSERT INTO users(id,first_name,last_name,city,ph) values (:id,:FirstName,:LastName,:City,:Ph)");
        writer.setDataSource(this.dataSource);
        return writer;
    }*//*



    //this method uses jpa Repository
    @Bean
    public RepositoryItemWriter<User> writer(){
        RepositoryItemWriter<User> writer = new RepositoryItemWriter<>();
        writer.setRepository(userRepository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step step1() {
       return this.stepBuilderFactory.get("step1")
                .<User,User>chunk(10)
                .reader(reader())
                .writer(writer())
                .processor(processor())
                .build();
    }


    //giving the step to job
    @Bean
    public Job importUserJob(){

        return this.jobBuilderFactory.get("USER-IMPORT-JOB")
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();

    }

}
*/
