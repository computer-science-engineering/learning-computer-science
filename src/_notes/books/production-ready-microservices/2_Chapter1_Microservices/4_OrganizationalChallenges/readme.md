# Organizational Challenges

When we find ourselves presented with technology that promises to offer us drastic improvements, we need to look for the trade-offs. Microservices promise greater scalability and greater efficiency, but we know that those will come at a cost to some part of the overall system.

There are four especially significant trade-offs that come with microservice architecture.

The first is the change in organizational structure that tends toward isolation and poor cross-team communication — a consequence of the inverse of Conway’s Law.

The second is the dramatic increase in technical sprawl, sprawl that is extraordinarily costly not only to the entire organization but which also presents significant costs to each engineer.

The third trade-off is the increased ability of the system to fail.

The fourth is the competition for engineering and infrastructure resources.

## The Inverse Conway’s Law

the organizational structure of a company is determined by the architecture of its product.

Microservice architecture is comprised of a large number of small, isolated, independent microservices. The Inverse Conway’s Law demands that the organizational structure of any company using microservice architecture will be made up of a large number of very small, isolated, and independent teams.

There is also a large communication gap between microservice teams and infrastructure teams that needs to be closed.

...difficulty of running an operations organization.

## Technical Sprawl

Suppose each of the many microservices is staffed by a development team of six developers, and each developer uses their own set of favorite tools, favorite libraries, and works in their own favorite languages. Each of these development teams has their own way of deploying, their own specified metrics to monitor and alert on, their own external libraries and internal dependencies they use,
custom scripts to run on production machines, and so on.

...thousand ways to deploy, a thousand libraries to maintain, a thousand different ways of alerting and monitoring and testing and handling outages. The only way to cut down on technical sprawl is through standardization at every level of the microservice ecosystem.

There’s another kind of technical sprawl associated with language choice. It’s more realistic to choose a small number of supported languages and ensure that all libraries and tools are compatible with and exist for these languages than to attempt to support a large number of languages.

The last type of technical sprawl we will cover here is technical debt, which usually refers to work that needs to be done because something was implemented in a way that got the job done quickly, but not in the best or most optimal way.

When outages happen, when things break, any work that comes out of an incident review will only rarely be the best overall solution: as far as microservice development teams are concerned, whatever fixes (or fixed) the problem quickly and in the moment was good enough, and any better solutions are pawned off to the future.

## More ways to fail

The reality of working with complex systems of this sort is that individual components will fail, they will fail often, and they will fail in ways that nobody could have predicted.

You can only do your best to prepare for when failure happens.

## Competition for Resources

There is no way to avoid competition for resources, though there are ways to mitigate competition somewhat. The most effective seems to be organizing or categorizing teams in terms of their importance and criticality to the overall business, and then giving teams access to resources based on their priority or importance. There are downsides to this, because it tends to result in poorly staffed development tools teams, and in projects whose importance lies in shaping the future (such as adopting new infrastructure technologies) being abandoned.