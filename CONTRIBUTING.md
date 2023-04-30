# Contributing to raaspi-jee 

RAASPI is a ready to use application offering predefined workflow models for many of the business applications including Small Business, ERP, Manufacturing, Agency, Clubs & Associations, Event Organizers. RAASPI is a multi tenant and multifunction ready application which can be used by ecommerce vendors, system integrators for their customers and companies for their departmental use. Your help making it popular will be greatly appreciated :)

There are many ways to contribute to the project!

- [Using the product for your own use as well as for your clients usage](https://www.raaspi.com/).
- Answering questions on the various RAASPI communities like the [support forum](http://forump.raaspi.com/).
- Testing open [issues](https://github.com/jayantamitra/raaspi-jee/issues) or [pull requests](https://github.com/jayantamitra/raaspi-jee/pulls) and sharing your findings in a comment.
- Testing RAASPI beta versions and release candidates. Those are announced in the [RAASPI development blog](http://blogs.raaspi.com/).
- Submitting fixes, improvements, and enhancements.
- Never report security related issues, vulnerabilities or bugs including sensitive information to the issue tracker, or elsewhere in public. Instead sensitive bugs must be sent by email to  mail@raaspi.com.

If you wish to contribute code, please read the information in the following sections. Then [fork](https://help.github.com/articles/fork-a-repo/) RAASPI, commit your changes, and [submit a pull request](https://help.github.com/articles/using-pull-requests/) 

We use the `good first issue` label to mark issues that are suitable for new contributors. You can find all the issues with this label [here](https://github.com/raaspi/raaspi/issues?q=is%3Aopen+is%3Aissue+label%3A%22type%3A+good+first+issue%22).

Raaspi is licensed under the Apache License 2.0, and all contributions to the project will be released under the same license. You maintain copyright over any contribution you make, and by submitting a pull request, you are agreeing to release that contribution under the Apache License 2.0.


## Getting started

- [How to set up Raaspi development environment](https://github.com/raaspify/raaspi-jee/wiki/How-to-set-up-Raaspi-development-environment)
- [Git Flow](https://github.com/raaspify/raaspi-jee/wiki/Raaspi-Git-Flow)
- [Naming conventions](https://github.com/raaspify/raaspi-jee/wiki/Naming-conventions)
- [String localisation guidelines](https://github.com/raaspify/raaspi-jee/wiki/String-localisation-guidelines)
- [Running unit tests](tbd)
- [Running e2e tests](tbd)

## Coding Guidelines and Development 🛠

- Ensure you read the readme.txt (https://github.com/raaspify/raaspi-jee/readme.txt)
- Run our build process described in the document on [how to set up Raaspi development environment](https://github.com/raaspify/raaspi-jee/wiki/How-to-set-up-Raaspi-development-environment), it will use templates and non template sources to generate final java and html files
- Ensure you use LF line endings in your code editor. Use [EditorConfig](http://editorconfig.org/) if your editor supports it so that indentation, line endings and other settings are auto configured.
- When committing, reference your issue number (#1234) and include a note about the fix.
- Push the changes to your fork and submit a pull request on the trunk branch of the Raaspi-jee repository.
- Make sure to write good and detailed commit messages (see [this post](https://chris.beams.io/posts/git-commit/) for more on this) and follow all the applicable sections of the pull request template.
- Please create a change file for your changes by running `pnpm --filter=<project> changelog add`. For example, a change file for the Raaspi Core project would be added by running `pnpm --filter=raaspi changelog add`. 
- Please avoid modifying the changelog directly or updating the .pot files. These will be updated by the Raaspi team. 

## Feature Requests 🚀

Feature requests can be [submitted to our issue tracker](https://github.com/raaspify/raaspi-jee/issues/new?assignees=&labels=type%3A+enhancement%2Cstatus%3A+awaiting+triage&template=2-enhancement.yml&title=%5BEnhancement%5D%3A+). Be sure to include a description of the expected behavior and use case, and before submitting a request, please search for similar ones in the closed issues.

Feature request issues will remain closed until we see sufficient interest via comments and [👍 reactions](https://help.github.com/articles/about-discussions-in-issues-and-pull-requests/) from the community.

You can see a [list of current feature requests which require votes here](https://github.com/raaspify/raaspi-jee/issues?q=is%3Aissue+sort%3Areactions-%2B1-desc+label%3A%22needs%3A+votes%22+).
