package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.PersonDAO;
import dto.PersonDTO;

/*
 Representational State Transfer(표현 상태 전이,REST)
REST API는 크게 리소스, 메서드, 메세지로 이루어져 있다.
예" 이름이 Terry인 사용자를 생성한다"라는 호출이 있을 때
-리소스 : "사용자" -> http://myrest/users라는 형태의 URI
-메소드 : "생성한다"라는 행위 -> HTTP POST메서드
-메세지 이름 : 이름이 Terry인 사용자 -> 생성하고자 하는 
                     사용자의 디테일한 내용은 JSON문서를 이용해서 표현
                     
GET(/myrest/person/list)           자료의 조회용
GET(/myrest/person/list/3)         자료의 조회용
DELETE(/myrest/person/3)           자료의 삭제
POST(/myrest/person/)+데이터          자료의 등록
PUT(/myrest/person/update)+데이터    자료의 수정  

@PathVariable-URI의 경로에서 원하는 데이터를 추출하는 용도로 사용
@RequestBody - 전송된 JSON데이터를 객체로 변환해 주는 어노테이션으로 
@ModeAndView와 유사한 역할을 하지만 JSON에서 사용된다는 점이 차이                     
 */
@Controller
public class PersonController {
	private PersonDAO dao;

	public PersonController() {

	}

	public void setDao(PersonDAO dao) {
		this.dao = dao;
	}

	// http://127.0.0.1:8090/myrest/person/list
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<PersonDTO> listMethod() {
		return dao.list();
	}

	// http://127.0.0.1:8090/myrest/person/list/2
	@RequestMapping(value = "/list/{ss}", method = RequestMethod.GET)
	public @ResponseBody PersonDTO listMethod(@PathVariable("ss") int num) {
		return dao.list(num);
	}

	// // http://127.0.0.1:8090/myrest/person/list/2/이영희
	// @RequestMapping(value = "/list/{num}/{name}", method = RequestMethod.GET)
	// public @ResponseBody PersonDTO listMethod(@PathVariable("num") int num,
	// @PathVariable("name") String name) {
	// PersonDTO dto = new PersonDTO();
	// dto.setName(name);
	// dto.setNum(num);
	// return dao.list(dto);
	// }

	// http://127.0.0.1:8090/myrest/person/list/2/이영희
	@RequestMapping(value = "/list/{num}/{name}", method = RequestMethod.GET)
	public @ResponseBody PersonDTO listMethod(PersonDTO dto) {
		return dao.list(dto);
	}

	///////////////////////////////////////////// 조회 끝

	/*
	 * $.ajax({ dataType:'text', type:'POST', data:
	 * JSON.stringify({"id":"user","pass":"4253","name":"야옹이"}), url:'/',
	 * success:function(res){} });
	 */

	// http://127.0.0.1:8090/myrest/person/
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<String> insertMethod(@RequestBody PersonDTO dto) {
		ResponseEntity<String> entity = null;
		try {
			dao.register(dto);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	////////////////////////////////////////////////// 삽입 끝

	// http://127.0.0.1:8090/myrest/person/update
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<String> updateMethod(@RequestBody PersonDTO dto) {
		ResponseEntity<String> entity = null;
		try {
			dao.update(dto);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	///////////////////////////////////////////////// 수정 끝

	// http://127.0.0.1:8090/myrest/person/3
	@RequestMapping(value = "/{num}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteMethod(@PathVariable("num") int num) {
		ResponseEntity<String> entity = null;
		try {
			dao.delete(num);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	/////////////////////////////////////////////////// 삭제 끝

}
