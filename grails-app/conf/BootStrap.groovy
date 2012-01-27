import com.spark.*
class BootStrap {
    def springSecurityService
    def init = { servletContext ->
       def userRole = SecRole.findByAuthority('ROLE_USER') ?: new SecRole(authority: 'ROLE_USER').save(failOnError: true)
       def adminRole = SecRole.findByAuthority('ROLE_ADMIN') ?: new SecRole(authority: 'ROLE_ADMIN').save(failOnError: true)
 
       def adminUser = SecUser.findByUsername('admin') ?: new SecUser(
                username: 'admin',
                password: 'admin',
                enabled: true).save(failOnError: true)
 
        if (!adminUser.authorities.contains(adminRole)) {
            SecUserSecRole.create adminUser, adminRole
        }
 
       def user1 = new User(fullName:"Paolo Foletto", 
       username:"suntzu",
       password:"t0ps3cr3t",
       email:"paolo.foletto@gmail.com",
       website:"este.linux.it",
       bio:''' una personalità 
               di un certo peso'''
    )
    if (!user1.save(flush: true)){
      user1.errors.allErrors.each{error ->
         println "An error occured with user1: ${error}"
         }
    }
    
    def user2 = new User(fullName:"Lucio Bruno", 
       username:"expertuslucius",
       password:"t0ps3cr3t",
       email:"expertuslucius@gmail.com",
       website:"este.linux.it",
       bio:''' la nuova leva del gruppo 
               che sviluppa in Arduino'''
    )
    if (!user2.save(flush: true)){
      user2.errors.allErrors.each{error ->
         println "An error occured with user2: ${error}"
         }
    }       
    def user3 = new User(fullName:"Cristian Greggio", 
       username:"gregg",
       password:"t0ps3cr3t",
       email:"cristiangreggio@gmail.com",
       website:"este.linux.it",
       bio:''' lunga esperienza  
               nelle installazioni di Linunx'''
    )
    if (!user3.save(flush: true)){
      user3.errors.allErrors.each{error ->
         println "An error occured with user3: ${error}"
         }
    }
    def user4 = new User(fullName:"Fabio Lovato", 
       username:"loviuz",
       password:"t0ps3cr3t",
       email:"fabio@l-web.it",
       website:"este.linux.it",
       bio:''' grande esperto 
               di grafica, user interface e Blender'''
    )
    if (!user4.save(flush: true)){
      user4.errors.allErrors.each{error ->
         println "An error occured with user4: ${error}"
         }
    }
    

    def event1 =   new Event (
         name:"Serata a tema Grails",
         location:"Este",
         venue:"IIS Euganeo",
         startDate: new Date('01/18/2012'),
         endDate: new Date('01/18/2012'),
         organizer: User.findByUsername("suntzu"),
         description: "Workshop Grails" )
      
         if (!event1.save(flush: true)){
            event1.errors.allErrors.each{error ->
               println "An error occured with event1: ${error}"
            }
         }
     event1.addToVolunteers(User.findByUsername("loviuz"))     
     event1.addToVolunteers(User.findByUsername("gregg"))     
     event1.addToVolunteers(User.findByUsername("expertuslucius"))     

     def event2 =   new Event (
         name:"Serata a tema Arduino",
         location:"Este",
         venue:"IIS Euganeo",
         startDate: new Date('03/14/2012'),
         endDate: new Date('03/14/2012'),
         organizer: User.findByUsername("expertuslucius"),
         description: "Arduino" )
      
         if (!event2.save(flush: true)){
            event1.errors.allErrors.each{error ->
               println "An error occured with event2: ${error}"
            }
         }
         
           def event3 =   new Event (
         name:"Serata a tema Software libero per PMI",
         location:"Este",
         venue:"IIS Euganeo",
         startDate: new Date('05/19/2012'),
         endDate: new Date('05/19/2012'),
         organizer: User.findByUsername("gregg"),
         description: "Software libero per PMI" )
      
         if (!event3.save(flush: true)){
            event1.errors.allErrors.each{error ->
               println "An error occured with event3: ${error}"
            }
         }
         
      def event4 =   new Event (
         name:"Serata a tema Blender",
         location:"Este",
         venue:"IIS Euganeo",
         startDate: new Date('09/19/2012'),
         endDate: new Date('09/19/2012'),
         organizer: User.findByUsername("loviuz"),
         description: "Blender" )
         if (!event4.save(flush: true)){
            event1.errors.allErrors.each{error ->
               println "An error occured with event4: ${error}"
            }
         }
    user1.setEnabled(true)?.save(flush: true)     
    user2.setEnabled(true)?.save(flush: true)     
    user3.setEnabled(true)?.save(flush: true)     
    user4.setEnabled(true)?.save(flush: true)     
    SecUserSecRole.create user1, userRole
    SecUserSecRole.create user1, adminRole
    SecUserSecRole.create user2, userRole
    SecUserSecRole.create user3, userRole
    SecUserSecRole.create user4, userRole

    }
    def destroy = {
    }
}
