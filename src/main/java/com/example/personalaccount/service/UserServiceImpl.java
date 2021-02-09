package com.example.personalaccount.service;

import com.example.personalaccount.repository.*;
import com.example.personalaccount.table.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class UserServiceImpl{

    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final GroupRepository groupRepository;
    private final SpecialityRepository specialityRepository;
    private final DepartmentRepository departmentRepository;
    private final CoursesRepository coursesRepository;
    private final UserRolesDepartRepository userRolesDepartRepository;
    private final UserGroupsRepository userGroupsRepository;
    private final UserSpecialCourseRepository userSpecialCourseRepository;
    private final UserCoursesDepartRepository userCoursesDepartRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository, RoleRepository roleRepository, GroupRepository groupRepository,
                           SpecialityRepository specialityRepository, DepartmentRepository departmentRepository,
                           CoursesRepository coursesRepository, UserRolesDepartRepository userRolesDepartRepository,
                           UserGroupsRepository userGroupsRepository,UserSpecialCourseRepository userSpecialCourseRepository,
                           UserCoursesDepartRepository userCoursesDepartRepository){
        this.repository=repository;
        this.roleRepository=roleRepository;
        this.groupRepository=groupRepository;
        this.specialityRepository=specialityRepository;
        this.departmentRepository=departmentRepository;
        this.coursesRepository=coursesRepository;
        this.userRolesDepartRepository=userRolesDepartRepository;
        this.userGroupsRepository=userGroupsRepository;
        this.userSpecialCourseRepository=userSpecialCourseRepository;
        this.userCoursesDepartRepository=userCoursesDepartRepository;
    }

    public List<UserLK> findALLuser(){
        List<UserLK> repositorys=repository.findAll();
        return repositorys;
    }

    public List<Role> findALLrole(){
        return roleRepository.findAll();
    }

    public List<GroupLK> findALLgroup(){
        return groupRepository.findAll();
    }

    public List<SpecialityLK> findAllspeciality(){return specialityRepository.findAll();}

    public List<Department> findAlldepartment(){return departmentRepository.findAll();}

    public List<CourcesLK> findAllcources(){return coursesRepository.findAll();}


    public UserLK getOneUser(UserLK userLK){return userLK;}

    public Role getOneRole(Role role){return role;}

    public GroupLK getOneGroup(GroupLK groupLK){return groupLK;}

    public SpecialityLK getOneSpeciality(SpecialityLK specialityLK){return specialityLK;}

    public Department getOneDepartment(Department department){return department;}

    public CourcesLK getOneDepartment(CourcesLK courcesLK){return courcesLK;}


    public UserLK createUser(UserLK userLK){
        return repository.save(userLK);
    }

    public Role createRole(Role role){
        return roleRepository.save(role);
    }

    public GroupLK createGroup(GroupLK groupLK){
        return groupRepository.save(groupLK);
    }

    public SpecialityLK createSpeciality(SpecialityLK specialityLK){
        return specialityRepository.save(specialityLK);
    }

    public Department createDepartment(Department department){
        return departmentRepository.save(department);
    }

    public CourcesLK create(CourcesLK courcesLK){
        return coursesRepository.save(courcesLK);
    }

    public UserRoleDepartment createUTD(Long userId, Long roleId, Long depId ){
        UserRoleDepartment userRoleDepartment=vale1(userId,roleId,depId);
        return userRolesDepartRepository.save(userRoleDepartment);
    }

    public UserGroup createUserGroups(Long userId, Long groupId){
        UserGroup userGroup = vale2(userId,groupId);
        return userGroupsRepository.save(userGroup);
    }

    public UserSpecialCourse createUSC(Long userId, Long specialId, Long courseId ){
        UserSpecialCourse userSpecialCourse=vale3(userId,specialId,courseId);
        return userSpecialCourseRepository.save(userSpecialCourse);
    }


    public UserCoursersDepartment createUCD(Long userId, Long courseId,Long depId){
        UserCoursersDepartment userCoursersDepartment = vale4(userId, courseId, depId);
        return userCoursesDepartRepository.save(userCoursersDepartment);
    }

    public void deleteUDT(Long userId, Long roleId, Long depId){
        UserRoleDepartment userRoleDepartment = vale1(userId,roleId,depId);
        userRolesDepartRepository.delete(userRoleDepartment);
    }

    public void deleteUserGroup(Long userId, Long groupId) {
        UserGroup userGroup = vale2(userId,groupId);
        userGroupsRepository.delete(userGroup);
    }


    public void deleteUSC(Long userId, Long specialId,Long courseId){
        UserSpecialCourse userSpecialCourse=vale3(userId,specialId,courseId);;
        userSpecialCourseRepository.delete(userSpecialCourse);
    }

    public void deleteUCD(Long userId, Long courseId, Long depId){
        UserCoursersDepartment userCoursersDepartment=vale4(userId,courseId,depId);
        userCoursesDepartRepository.delete(userCoursersDepartment);
    }


    public UserLK updateUser(UserLK userUpdateDB,  UserLK userLK){
        BeanUtils.copyProperties(userLK,userUpdateDB,"id");

        return repository.save(userUpdateDB);
    }

    public Role updateRole(Role roleUpdateDB,  Role roleLK){
        BeanUtils.copyProperties(roleLK,roleUpdateDB,"id");

        return roleRepository.save(roleUpdateDB);
    }

    public GroupLK updateGroupLK(GroupLK groupUpdateDB,  GroupLK groupLK){
        BeanUtils.copyProperties(groupLK,groupUpdateDB,"id");

        return groupRepository.save(groupUpdateDB);
    }

    public SpecialityLK updateSpeciality(SpecialityLK specialityUpdateDB,  SpecialityLK specialityLK){
        BeanUtils.copyProperties(specialityLK,specialityUpdateDB,"id");

        return specialityRepository.save(specialityUpdateDB);
    }

    public Department updateDepartment(Department departmentUpdateDB,  Department departmentLK){
        BeanUtils.copyProperties(departmentLK,departmentUpdateDB,"id");

        return departmentRepository.save(departmentUpdateDB);
    }

    public CourcesLK updateCources(CourcesLK courcesLKUpdateLK,  CourcesLK courcesLK){
        BeanUtils.copyProperties(courcesLK,courcesLKUpdateLK,"id");

        return coursesRepository.save(courcesLKUpdateLK);
    }



    public void deleteUser(Long id) {
        UserLK userLK= repository.findByUserId(id);
        repository.delete(userLK);
    }

    public void deleteRole(Long id) {
        Role roleLK=roleRepository.findByUserIdR(id);
        roleRepository.delete(roleLK);
    }

    public void deleteGroup(Long id) {
        GroupLK groupLK=groupRepository.findByGroupId(id);
        groupRepository.delete(groupLK);
    }

    public void deleteSpeciality(Long id) {
        SpecialityLK specialityLK=specialityRepository.findBySpecialityId(id);
        specialityRepository.delete(specialityLK);
    }

    public void deleteCourse(Long id) {
        CourcesLK courcesLK=coursesRepository.findByCourcesId(id);
        coursesRepository.delete(courcesLK);
    }

    public void deleteDepartment(Long id) {
        Department department=departmentRepository.findByDepartmentId(id);
        departmentRepository.delete(department);
    }


    private UserRoleDepartment vale1(Long userId, Long roleId, Long depId){
        UserRoleDepartment userRoleDepartment = new UserRoleDepartment();
        UserLK userLK=repository.findByUserId(userId);
        Role role=roleRepository.findByUserIdR(roleId);
        Department department=departmentRepository.findByDepartmentId(depId);
        userRoleDepartment.setUserLK(userLK);
        userRoleDepartment.setRoleUser(role);
        userRoleDepartment.setDepartment(department);
        return userRoleDepartment;
    }

    private UserGroup vale2(Long userId, Long groupId){
        UserGroup userGroup = new UserGroup();
        UserLK userLK = repository.findByUserId(userId);
        GroupLK groupLK = groupRepository.findByGroupId(groupId);
        userGroup.setUserGroupLK(userLK);
        userGroup.setGroupLK(groupLK);
        return userGroup;
    }

    private UserSpecialCourse vale3(Long userId, Long specialId, Long courseId){
        UserSpecialCourse userSpecialCourse = new UserSpecialCourse();
        UserLK userLK=repository.findByUserId(userId);
        SpecialityLK specialityLK=specialityRepository.findBySpecialityId(specialId);
        CourcesLK courcesLK=coursesRepository.findByCourcesId(courseId);
        userSpecialCourse.setUserSLK(userLK);
        userSpecialCourse.setSpecialityLK(specialityLK);
        userSpecialCourse.setCourcesSLK(courcesLK);
        return userSpecialCourse;
    }

    private UserCoursersDepartment vale4(Long userId, Long courseId, Long depId){
        UserCoursersDepartment userCoursersDepartment = new UserCoursersDepartment();
        UserLK userLK=repository.findByUserId(userId);
        CourcesLK courcesLK=coursesRepository.findByCourcesId(courseId);
        Department departmentLK=departmentRepository.findByDepartmentId(depId);
        userCoursersDepartment.setUserL(userLK);
        userCoursersDepartment.setCourcesLK(courcesLK);
        userCoursersDepartment.setDepartmentL(departmentLK);
        return userCoursersDepartment;
    }

}
