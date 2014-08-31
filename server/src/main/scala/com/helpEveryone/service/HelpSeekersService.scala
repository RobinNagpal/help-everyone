package com.helpEveryone.service

import com.helpEveryone.domain.HelpSeeker
import com.helpEveryone.repository.HelpSeekersRepo

trait HelpSeekersService extends BaseService[HelpSeeker]{

}

class HelpSeekerServiceImpl(helpSeekerRepo:HelpSeekersRepo) extends BaseServiceImpl[HelpSeeker](helpSeekerRepo:HelpSeekersRepo)  with HelpSeekersService