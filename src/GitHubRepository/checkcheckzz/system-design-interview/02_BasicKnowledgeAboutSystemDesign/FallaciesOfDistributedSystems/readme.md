# Fallacies of Distributed Computing Explained

The 8 fallacies of distributed computing [Gosling]:

1. The network is reliable.
2. Latency is zero.
3. Bandwidth is infinite.
4. The network is secure.
5. Topology doesn't change.
6. There is one administrator.
7. Transport cost is zero.
8. The network is homogeneous.

## The network is reliable

On the infrastructure side, you need to think about hardware and software redundancy and weigh the risks of failure versus the required
investment.

On the software side, you need to think about messages/calls getting lost whenever you send a message/make a call over the wire. For one
you can use a communication medium that supplies full reliable messaging; WebsphereMQ or MSMQ, for example. If you can't use one, prepare to retry, acknowledge important messages, identify/ignore duplicates (or use idempotent messages), reorder messages (or not depend on message order), verify message integrity, and so on.

To sum up, the network is Unreliable and we as software architect/designers need to address that.

## Latency is zero

Latency is how much time it takes for data to move from one place to another (versus bandwidth which is how much data we can transfer during that time). Latency can be relatively good on a LAN--but latency deteriorates quickly when you move to WAN scenarios or internet scenarios.

Taking latency into consideration means you should strive to make as few as possible calls and assuming you have enough bandwidth you'd want to move as much data out in each of this calls. There is a nice example illustrating the latency problem and what was done to solve it in Windows Explorer in <http://blogs.msdn.com/oldnewthing/archive/2006/04/07/570801.aspx>.

Asynchronous patterns such as AJAX can help, but if data retrieval is not fast enough the application would still stagger and will be unresponsive.

You can (and should) use tools to simulate network conditions and understand system behavior thus avoiding failure in the production system.

## Bandwidth is infinite

While bandwidth is growing, so is the amount of data we are trying to send across.

The other force at work to lower bandwidth is packet loss (along with frame size).

Acknowledging the bandwidth is not infinite has a balancing effect on the implications of the the "Latency Is Zero" fallacy; that is, if acting
on the realization the latency is not zero we modeled few large messages. Bandwidth limitations direct us to strive to limit the size of the information we send over the wire.

The main implication then is to consider that in the production environment of our application there may be bandwidth problems which are beyond our control. And we should bear in mind how much data is expected to travel over the wise.

The recommendation from the previous post - to try to simulate the production environment - holds true here as well.

## The Network is Secure

The implications of network (in) security are obvious - you need to build security into your solutions from Day 1. I mentioned in a previous blog post that security is a system quality attribute that needs to be taken into consideration starting from the architectural level.

In essence you need to perform threat modeling to evaluate the security risks. Then following further analyses decide which risk are should be mitigated by what measures (a tradeoff between costs, risks and their probability). Security is usually a multi-layered solution that is handled on the network, infrastructure, and application levels.

As an architect you might not be a security expert - but you still need to be aware that security is needed and the implications it may have (for instance, you might not be able to use multicast, user accounts with limited privileges might not be able to access some networked resource etc.)

## Topology doesn’t change

The fifth Distributed Computing Fallacy is about network topology.

When you deploy an application in the wild (that is, to an organization), the network topology is usually out of your control. The operations team (IT) is likely to add and remove servers every once in a while and/or make other changes to the network ("this is the new Active Directory we will use for SSO ; we're replacing RIP with OSPF and this application's servers are moving into area 51" and so on). Lastly there are server and network faults which can cause routing changes.

When you're talking about clients, the situation is even worse. There are laptops coming and going, wireless ad-hoc networks , new mobile devices. In short, topology is changing constantly.

What does this mean for the applications we write? Simple. Try not to depend on specific endpoints or routes, if you can't be prepared to renegotiate endpoints. Another implication is that you would want to either provide location transparency (e.g. using an ESB, multicast) or provide discovery services (e.g. a Active Directory/JNDI/LDAP). Another strategy is to abstract the physical structure of the network. The most obvious example for this is DNS names instead of IP addresses. An interesting example is moving from WS-Routing to [WS-Addressing](http://xml.coverpages.org/ws-Addressing.html). Another example is routing in SQL Server Service Broker.

## There is one administrator

The sixth Distributed Computing Fallacy is "There is one administrator". You may be able to get away with this fallacy if you install your software on small, isolated LANs (for instance, a single person IT "group" with no WAN/Internet). However, for most enterprise systems the reality is much different.

The IT group may have different administrators, assigned according to expertise. The company may collaborate with external entities. Or, the application may be deployed for Internet consumption and hosted by some hosting service and the application consumes external services (think [Mashups](http://en.wikipedia.org/wiki/Mashup_(web_application_hybrid))). In these situations, the other administrators are not even under your control and they may have their own agendas/rules.

The administrators will most likely not be part of your development team so we need provide them with tools to diagnose and find problems. This is essential when the application involves more than one company ("Is it their problem or our's?"). A proactive approach is to also include tools for monitoring on-going operations as well; for instance, to allow administrators identify problems when they are small - before they become a system
failure.

Another reason to think about multiple administrators is upgrades. How are you going to handle them? How are you going to make sure that the different parts of our application (distributed, remember?) are synchronized and can actually work together. This problem aggravates when third parties are involved. Can your partner continue to interop with our system when we made changes to the public contract (in an SOA) so, for example, you need to think about backward compatibility (or maybe even forward compatibility) when designing interoperability contracts.

To sum up, when there is more than one administrator (unless we are talking about a simple system and even that can evolve later if it is successful), you need to remember that administrators can constrain your options (administrators that sets disk quotas, limited privileges, limited ports and protocols and so on), and that you need to help them manage your applications.

## Transport cost is zero

There are a couple of ways you can interpret this statement, both of which are false assumptions.

One way is that going from the application level to the transport level is free. This is a fallacy since we have to do marshaling (serialize information into bits) to get data unto the wire, which takes both computer resources and adds to the latency. Interpreting the statement this way emphasizes the "Latency is Zero" fallacy by reminding us that there are additional costs (both in time and resources).

The second way to interpret the statement is that the costs (as in cash money) for setting and running the network are free. This is also far
from being true. There are costs--costs for buying the routers, costs for securing the network, costs for leasing the bandwidth for internet
connections, and costs for operating and maintaining the network running. Someone, somewhere will have to pick the tab and pay these costs.

The takeaway is that even in situations you think the other fallacies are not relevant to your situation because you rely on existing solutions you may still be bounded by the costs of the solution and you'd need to solve your problems using more cost-effective solutions.

## The network is homogeneous

Assuming this fallacy should not cause too much trouble at the lower network level as IP is pretty much ubiquitous.

It is worthwhile to pay attention to the fact the network is not homogeneous at the application level. The implication of this is that you have to assume interoperability will be needed sooner or later and be ready to support it from day one (or at least design where you'd add it later).

Do not rely on proprietary protocols--it would be harder to integrate them later. Do use standard technologies that are widely accepted; the most notable examples being XML or Web Services. By the way, much of the popularity of XML and Web Services can be attributed to the fact that both these technologies help alleviate the affects of the heterogeneity of the enterprise environment.

To sum up, most architects/designers today are aware of this fallacy, which is why interoperable technologies are popular. Still it is something you need to keep in mind especially if you are in a situation that mandates use of proprietary protocols or transports.

## Conclusion

With almost 15 years since the fallacies were drafted and more than 40 years since we started building distributed systems – the characteristics and underlying problems of distributed systems remain pretty much the same.

Remember that (successful) applications evolve and grow so even if things look Ok for a while if you don't pay attention to the issues covered by the fallacies they will rear their ugly head and bite you.

## References

1. [Fallacies of Distributed Computing Explained](https://pages.cs.wisc.edu/~zuyu/files/fallacies.pdf)
2. [Britton2001] IT Architecture & Middleware, C. Britton, AddisonWesley 2001, ISBN 0-201-70907-4
3. [JDJ2004](http://java.sys-con.com/read/38665.htm)
4. [Gosling](http://blogs.sun.com/roller/page/jag)
5. [Ingo](http://blogs.thinktecture.com/ingo/archive/2005/11/08/LatencyVsBandwidth.aspx)
6. [RichUI](http://richui.blogspot.com/2005/09/ajax-latency-problemsmyth-or-reality.html)
7. [WareOnEarth](http://sd.wareonearth.com/~phil/jumbo.html)
8. [Aladdin](http://www.esafe.com/home/csrt/statistics/statistics_2005.asp)
9. [RipTech](http://www.riptech.com/)
10. [CERT](http://www.cert.org/stats/#incidents)
11. [Adams](http://www.dilbert.com/comics/dilbert/archive/dilbert20060516.html)
