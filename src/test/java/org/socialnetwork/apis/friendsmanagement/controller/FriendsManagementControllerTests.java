package org.socialnetwork.apis.friendsmanagement.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.socialnetwork.apis.friendsmanagement.dto.AccountDTO;
import org.socialnetwork.apis.friendsmanagement.dto.FriendConnectionDTO;
import org.socialnetwork.apis.friendsmanagement.dto.FriendsListDTO;
import org.socialnetwork.apis.friendsmanagement.dto.NotifyDTO;
import org.socialnetwork.apis.friendsmanagement.dto.UserEmailDTO;
import org.socialnetwork.apis.friendsmanagement.entity.UserEntity;
import org.socialnetwork.apis.friendsmanagement.service.FriendConnectionService;
import org.socialnetwork.apis.friendsmanagement.service.NotificationService;
import org.socialnetwork.apis.friendsmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringRunner.class)
@WebMvcTest(value = FriendsManagementController.class)
public class FriendsManagementControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private FriendConnectionService friendConnectionService;

    @MockBean
    private NotificationService notificationService;

    @Test
    public void account() throws Exception {
        UserEntity response = new UserEntity("test@gmail.com", "test", "test@123");
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername("test");
        accountDTO.setEmail("test@gmail.com");
        accountDTO.setPassword("test@123");
        Mockito.when(
            userService.account(accountDTO)).thenReturn(response);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(accountDTO);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
            "/friendsmanagement/account").accept(
                MediaType.APPLICATION_JSON)
            .content(requestJson)
            .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{success:true}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void friends() throws Exception {
        List<String> friendList = new ArrayList<String>();
        friendList.add("test1@example.com");
        friendList.add("test2@example.com");
        UserEmailDTO userEmail = new UserEmailDTO();
        userEmail.setEmail("test@example.com");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(userEmail);
        Mockito.when(
            friendConnectionService.friendsList(Mockito.any())).thenReturn((friendList));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
            "/friendsmanagement/friends").accept(
                MediaType.APPLICATION_JSON)
            .content(requestJson)
            .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        FriendsListDTO fiendListDTO = new FriendsListDTO(friendList);
        String responsejson = ow.writeValueAsString(fiendListDTO);
        JSONAssert.assertEquals(responsejson, response.getContentAsString(), false);
        assertEquals(200, response.getStatus());
        assertNotNull(result);
    }

    @Test
    public void commonFriends() throws Exception {
        List<String> friendList = new ArrayList<String>();
        friendList.add("test3@example.com");
        friendList.add("test4@example.com");
        FriendConnectionDTO friendConnDTO = new FriendConnectionDTO();
        friendConnDTO.setFriends(friendList);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(friendConnDTO);
        Mockito.when(
            friendConnectionService.commonFriends(Mockito.any())).thenReturn((friendList));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
            "/friendsmanagement/common").accept(
                MediaType.APPLICATION_JSON)
            .content(requestJson)
            .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        FriendsListDTO fiendListDTO = new FriendsListDTO(friendList);
        String responsejson = ow.writeValueAsString(fiendListDTO);
        JSONAssert.assertEquals(responsejson, response.getContentAsString(), false);
        assertEquals(200, response.getStatus());
        assertNotNull(result);

    }

    @Test
    public void notification() throws Exception {
        NotifyDTO notifyDTO = new NotifyDTO();
        notifyDTO.setSender("test1.example.com");
        notifyDTO.setText("Hello");
        List<String> friendList = new ArrayList<String>();
        friendList.add("test3@example.com");
        friendList.add("test4@example.com");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(notifyDTO);
        Mockito.when(
            notificationService.notify(Mockito.any())).thenReturn((friendList));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
            "/friendsmanagement/notify").accept(
                MediaType.APPLICATION_JSON)
            .content(requestJson)
            .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(400, response.getStatus());
        assertNotNull(result);

    }

}
