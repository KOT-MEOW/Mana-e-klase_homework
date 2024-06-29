package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Child;
import lv.venta.model.ChildRating;
import lv.venta.model.ChildrenGroup;
import lv.venta.model.RaitingValues;
import lv.venta.model.Teacher;
import lv.venta.repo.IChildRatingRepo;
import lv.venta.repo.IChildRepo;
import lv.venta.repo.IChildrenGroupRepo;
import lv.venta.repo.ITeacherRepo;

@SpringBootApplication
public class ManaEKlaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManaEKlaseApplication.class, args);
	}

	@Bean
	public CommandLineRunner testDB(
			ITeacherRepo teacherRepo,
			IChildrenGroupRepo childrenGroupRepo,
			IChildRepo childRepo,
			IChildRatingRepo childRatingRepo){
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				//Teacher
				Teacher t1 = new Teacher("Anton","Sakraev");
				Teacher t2 = new Teacher("Salli","Maksava");
				teacherRepo.save(t1);
				teacherRepo.save(t2);
				
				//CholdrenGroup
				ChildrenGroup chg1 = new ChildrenGroup("Sawaqasa", 2023, t1);
				ChildrenGroup chg2 = new ChildrenGroup("Kastalis", 2024, t1);
				ChildrenGroup chg3 = new ChildrenGroup("Uwqas", 2022, t2);
				childrenGroupRepo.save(chg1);
				childrenGroupRepo.save(chg2);
				childrenGroupRepo.save(chg3);
				
				//Child
				Child c1 = new Child("Ola","Kasjas","Lasta", chg1);
				Child c2 = new Child("Piens","Jansja","Poqsa", chg1);
				Child c3 = new Child("","Kasjas","Lasta", chg2);
				Child c4 = new Child("","Lila","Lasta", chg2);
				Child c5 = new Child("","Jasisa","Jaksaw", chg2);
				childRepo.save(c1);
				childRepo.save(c2);
				childRepo.save(c3);
				childRepo.save(c4);
				childRepo.save(c5);
				
				//ChildRating
				ChildRating chra1 = new ChildRating("prot dejot", RaitingValues.apgust, c1);
				ChildRating chra2 = new ChildRating("prot dziedat", RaitingValues.nav_apguts, c1);
				ChildRating chra3 = new ChildRating("prot zimet", RaitingValues.padzilinati_apgust, c1);
				ChildRating chra4 = new ChildRating("prot limet", RaitingValues.apgust, c2);
				ChildRating chra5 = new ChildRating("prot krasot", RaitingValues.apgust, c2);
				ChildRating chra6 = new ChildRating("prot dziedat", RaitingValues.turpina_apgut, c3);
				ChildRating chra7 = new ChildRating("prot dejot", RaitingValues.nav_apguts, c4);
				ChildRating chra8 = new ChildRating("prot dejot", RaitingValues.apgust, c4);
				ChildRating chra9 = new ChildRating("prot limet", RaitingValues.padzilinati_apgust, c5);
				ChildRating chra10 = new ChildRating("prot zimet", RaitingValues.apgust, c5);
				ChildRating chra11 = new ChildRating("prot dejot", RaitingValues.turpina_apgut, c5);
				childRatingRepo.save(chra1);
				childRatingRepo.save(chra2);
				childRatingRepo.save(chra3);
				childRatingRepo.save(chra4);
				childRatingRepo.save(chra5);
				childRatingRepo.save(chra6);
				childRatingRepo.save(chra7);
				childRatingRepo.save(chra8);
				childRatingRepo.save(chra9);
				childRatingRepo.save(chra10);
				childRatingRepo.save(chra11);
						
			}
		};}
	
	
}
