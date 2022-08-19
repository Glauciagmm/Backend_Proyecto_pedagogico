package com.uniquecare.pedagogico_backend.controllers;

import com.uniquecare.pedagogico_backend.models.User;
import com.uniquecare.pedagogico_backend.services.IUserService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

/*
    private MockMvc mockMvc;

    public UserControllerTest(MockMvc mockMvc){
        this.mockMvc = mockMvc;
    }

    @MockBean
    private IUserService userService;

    @Test
    public void findUserById() throws Exception {

        User user = new User();
        user.setName("Test Name");
        user.setSurname("surname");
        user.setUsername("username");
        user.setEmail("email");
        user.setPassword("password");
        user.setCity("city");
        user.setPhone("phone");
        user.setPhoto("photo");
        user.setId(1L);

        given(userService.getUserById(user.getId())).willReturn(user);

        mockMvc.perform(get("/users/" + user.getId().toString())
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is(user.getName())));
    }
*/


   /* @Mock
    private UserRepository userRepositoryMock;
    private IUserService userServiceUnderTest;

    @Mock
    private PasswordEncoder encoderUnderTest;*/


   /* UserControllerTest(IUserService userService, UserRepository userRepository, PasswordEncoder encoder) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }*/

    /*@BeforeEach
    void setUp() {

        userServiceUnderTest = new UserServiceImplements(userRepositoryMock);
    }*/

    /*@Test
    public void getUsers() throws Exception {
        addSampleUsers();
        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(2)))
                .andExpect(jsonPath("$[0].name", equalTo("Glau")))
                .andExpect(jsonPath("$[0].surname", equalTo("Glaucia")))
                .andExpect(jsonPath("$[0].username", equalTo("Mesquita")))
                .andExpect(jsonPath("$[0].email", equalTo("glau@test.com")))
                .andExpect(jsonPath("$[0].city", equalTo("glau@test.com")))
                .andExpect(jsonPath("$[0].phone", equalTo("23456789")))
                .andExpect(jsonPath("$[0].photo", equalTo("xxxxxxxx")))
                .andExpect(jsonPath("$[0].password", equalTo("123789456")))
                .andExpect(jsonPath("$[1].name", equalTo("Glau")))
                .andExpect(jsonPath("$[1].surname", equalTo("Glaucia")))
                .andExpect(jsonPath("$[1].username", equalTo("Mesquita")))
                .andExpect(jsonPath("$[1].email", equalTo("glau@test.com")))
                .andExpect(jsonPath("$[1].city", equalTo("glau@test.com")))
                .andExpect(jsonPath("$[1].phone", equalTo("23456789")))
                .andExpect(jsonPath("$[1].photo", equalTo("xxxxxxxx")))
                .andExpect(jsonPath("$[1].password", equalTo("123789456")))
                        .andDo(print());
    }

    private void addSampleUsers(){
        List<User> users = List.of(
                new User(
                        "Glau",
                        "Glaucia",
                        "Mesquita",
                        "glau@test.com",
                        "Barcelona",
                        "123456789",
                        "xxxxxxxx",
                        "123789456"),

                new User(
                        "Glau",
                        "Glaucia",
                        "Mesquita",
                        "glaucia",
                        "Glaucia@gmail.com",
                        "123456789",
                        "Barcelona",
                        "123789456")

                );
        userRepository.saveAll(users);
    }

    @Test
    void updateUser() {
    }

    @Test
    void testGetUsers() {
    }

    @Test
    void findUserById() throws Exception {
        User user = userRepository.save(new User(
                "Glau",
                "Glaucia",
                "Mesquita",
                "glau@test.com",
                "Barcelona",
                "123456789",
                "xxxxxx",
                "123789456"
        ));
        mockMvc.perform(get("/user/"+user.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("Glau")))
                .andExpect(jsonPath("$.surname", equalTo("Glaucia")))
                .andExpect(jsonPath("$.username", equalTo("Mesquita")))
                .andExpect(jsonPath("$.email", equalTo("glau@test.com")))
                .andExpect(jsonPath("$.city", equalTo("Barcelona")))
                .andExpect(jsonPath("$.phone", equalTo("123456789")))
                .andExpect(jsonPath("$.photo", equalTo("xxxxxx")))
                .andExpect(jsonPath("$.password", equalTo("123789456")));
    }


    @Test
    void testUpdateUser() throws Exception {
       User user = userRepository.save(new User(
                "Glau",
                "Glaucia",
                "Mesquita",
                "glaucia@test.com",
                "Barcelona",
                "123456789",
                "xxxxxx",
                "123456789"
        ));
        mockMvc.perform(put("/api//user/edit/{id}")
                .contentType(APPLICATION_JSON)
                .content("{"+
                        "\"id\":\""+user.getId()+"\", "+
                        "\"name\":\"Glau\", "+
                        "\"surname\":\"Glaucia\", "+
                        "\"username\":\"Mesquita\", "+
                        "\"email\":\"glaucia@test.com\", "+
                        "\"city\":\"Barcelona\", "+
                        "\"phone\":\"123456789\", "+
                        "\"photo\":\"xxxxxx\","+
                        "\"password\":\"123456789\" }")
                        ).andExpect(status().isOk());

        List<User> users = userRepository.findAll();
        assertThat(users, hasSize(1));
        assertThat(users.get(0).getName(), equalTo("Glau"));
        assertThat(users.get(0).getSurname(), equalTo("Glaucia"));
        assertThat(users.get(0).getPhoto(), equalTo("xxxxxx"));
    }*/


  /*  @Test
    void deleteUser() throws Exception {
        User user = userRepository.save(new User(1L, "Glaucia", "Mesquita", "glau", "glau@test.com","city", "123354", "photo", "password"));
        underTest.perform(deleteUser("/api/user/delete"+user.getId()));
                andExpect(status().isOk());
        underTest.deleteUser(1L);
        verify(userRepository).deleteById(1L);
    }*/

   /* @Test
    RequestBuilder deleteUser(String users) throws Exception{
        User user = userRepository.save(new User(1L));
        mockMvc.perform(deleteUser("/user/" + user.getId())).andExpect(status().isOk());

     List<User> users = userRepository.findAll();
        assertThat (users, not(contains(allOf(
                hasProperty("id", is (1L))
               *//* hasProperty("name", is ("Glaucia")),
                hasProperty("username", is ("Mesquita")),
                hasProperty("email", is ("glau@glau.com")),
                hasProperty("city", is ("barcelona"))*//*
        ))));
        return null;
    }*/


}
