package DigitalEye.demo.repository;


import DigitalEye.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
User 엔티티를 데이터베이스에서 조회, 저장, 수정, 삭제하는데 사용됨.
JpaRepository를 상속받음. -> 자동으로 CRUD 메서드 제공, 추가적 쿼리 작성 가능,
                            데베와 자바 객체간의 매핑 자동처리해줌
 */
public interface UserRepository extends JpaRepository<User, Long> {
}