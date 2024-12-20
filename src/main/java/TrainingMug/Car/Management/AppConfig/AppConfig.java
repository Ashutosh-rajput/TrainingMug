package TrainingMug.Car.Management.AppConfig;

import TrainingMug.Car.Management.Mapper.CarMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public CarMapper carMapper(){return new CarMapper();}

//    @Bean
//    public StudentServiceImpl studentService(){return new StudentServiceImpl();}
}
